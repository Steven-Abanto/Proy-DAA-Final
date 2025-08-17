import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { LoanService } from '../../services/loan.service';
import { finalize } from 'rxjs/operators';
import { PrestamoConDetalles } from '../../models/loan-with-details.dto';



@Component({
  selector: 'app-loan.add.component',
  imports: [ReactiveFormsModule],
  templateUrl: './loan.add.component.html',
  styleUrl: './loan.add.component.scss',
})
export class LoanAddComponent {
  form!: FormGroup;
  loading = false;

  constructor(
    private fb: FormBuilder,
    private loanService: LoanService,
    private router: Router,
    private toastr: ToastrService
  ) {
    this.form = this.fb.group({
      tipoPrestamo:  ['', [Validators.required]],
      cuentaDestin: ['', [Validators.required, Validators.pattern(/^\d{18}$/)]],
      monto:         ['', [Validators.required, Validators.min(1)]],
      tasaInt:       ['', [Validators.required, Validators.min(3.5)]],
      cuotas:        ['', [Validators.required, Validators.min(1)]]
    });
  }

async save() {
  if (this.form.invalid) {
    this.form.markAllAsTouched();
    this.toastr.warning('Revisa los datos del formulario.');
    return;
  }

  this.loading = true;
  this.form.disable();

  const move = this.form.value;

  // Normaliza monto a número
  const montoNumber =
    typeof move.monto === 'string'
      ? parseFloat(move.monto.replace(',', '.'))
      : move.monto;

  const fechaActual = new Date();

  // Construye el objeto completo con préstamo y detalles
  const payload: PrestamoConDetalles = {
    prestamo: {
      tipoPrestamo: move.tipoPrestamo,
      monto: isNaN(montoNumber) ? 0 : montoNumber,
      fecha: fechaActual
    },
    detalles: [{
      uidCuenta: parseInt(move.cuentaDestin),
      montoPrestamo: 0,
      tasaInt: parseFloat(move.tasaInt),
      cuotas: parseInt(move.cuotas),
      deuda_cuota: this.calcularCuota(montoNumber, move.tasaInt, move.cuotas),
      deuda_total: this.calcularTotal(montoNumber, move.tasaInt),
      fecha: fechaActual
    }]
  };


  this.loanService.createLoanConDetalles(payload)
    .pipe(finalize(() => {
      this.form.enable();
      this.loading = false;
    }))
    .subscribe({
      next: () => {
        this.toastr.success('Préstamo registrado correctamente');
        this.router.navigate(['loans/list']);
      },
      error: (error) => {
        console.error('Error al registrar préstamo:', error);
        const backendMessage = error?.error?.message || 'Error al registrar préstamo';
        this.toastr.error(backendMessage);
      }
    });
}

calcularCuota(monto: number, tasa: number, cuotas: number): number {
  const t = tasa;
  const c = cuotas;
  return +(monto * (1 + t / 100) / c).toFixed(2);
}

calcularTotal(monto: number, tasa: number): number {
  const t = tasa;
  return +(monto * (1 + t / 100)).toFixed(2);
}



  cancel() {
    this.router.navigate(['loans/list']);
  }
}
