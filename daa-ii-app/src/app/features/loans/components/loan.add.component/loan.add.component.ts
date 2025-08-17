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

    const loan = {
      uid: move.uid,
      tipoPrestamo: move.tipoPrestamo,
      monto: isNaN(montoNumber) ? 0 : montoNumber,
      fecha: new Date()
    };

    this.loanService.createLoan(loan)
      .pipe(finalize(() => {
        this.form.enable();
        this.loading = false;
      }))
      .subscribe({
        next: () => {
          this.toastr.success('Cuenta registrada correctamente');
          this.router.navigate(['loans/list']);
        },
        error: (error) => {
          console.error('Error al registrar cuenta:', error);
          const backendMessage = error?.error?.message || 'Error al registrar cuenta';
          this.toastr.error(backendMessage);
        }
      });
  }

  cancel() {
    this.router.navigate(['loans/list']);
  }
}
