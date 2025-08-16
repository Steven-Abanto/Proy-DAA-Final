import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MovementService } from '../../services/movement.service';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-movement.add.component',
  imports: [ReactiveFormsModule],
  templateUrl: './movement.add.component.html',
  styleUrl: './movement.add.component.scss',
})
export class MovementAddComponent {
  form!: FormGroup;
  loading = false;

  constructor(
    private fb: FormBuilder,
    private movementService: MovementService,
    private router: Router,
    private toastr: ToastrService
  ) {
    this.form = this.fb.group({
      cuentaOrigen:  ['', [Validators.required, Validators.pattern(/^\d{18}$/)]],
      cuentaDestin: ['', [Validators.required, Validators.pattern(/^\d{18}$/)]],
      monto:         ['', [Validators.required, Validators.min(1)]],
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

    const movement = {
      uid: move.uid,
      cuentaOrigen: move.cuentaOrigen,
      cuentaDestin: move.cuentaDestin,
      monto: isNaN(montoNumber) ? 0 : montoNumber,
      fecha: new Date()
    };

    this.movementService.createMovement(movement)
      .pipe(finalize(() => {
        this.form.enable();
        this.loading = false;
      }))
      .subscribe({
        next: () => {
          this.toastr.success('Cuenta registrada correctamente');
          this.router.navigate(['movements/list']);
        },
        error: (error) => {
          console.error('Error al registrar cuenta:', error);
          const backendMessage = error?.error?.message || 'Error al registrar cuenta';
          this.toastr.error(backendMessage);
        }
      });
  }

  cancel() {
    this.router.navigate(['movements/list']);
  }
}
