import { Component, computed, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MovementInterface } from '../../interfaces/movement.interface';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MovementService } from '../../services/movement.service';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-movement.update.component',
  imports: [ReactiveFormsModule],
  templateUrl: './movement.update.component.html',
  styleUrl: './movement.update.component.scss'
})
export class MovementUpdateComponent implements OnInit {
  form!: FormGroup;
  loading = false;
  movementId: string;
  movementData: MovementInterface | null = null;

  constructor(
    private fb: FormBuilder,
    private movementService: MovementService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService
  ) {
    this.form = this.fb.group({
      nroCuenta: [{ value: '', disabled: true }],
      saldo:     [{ value: 0,  disabled: true }],
      tipoCuenta: ['', Validators.required],
      compraInt: [false]
    });

    this.movementId = this.route.snapshot.paramMap.get('uid')!;
  }

  async ngOnInit() {
    await this.loadMovementData();
  }

  async loadMovementData() {
    this.loading = true;
    try {
      const data = await firstValueFrom(
        this.movementService.getMovementById(this.movementId) // Observable<MovementInterface>
      );

      this.movementData = data;

      this.form.patchValue({
        cuentaOrigen: data.cuentaOrigen,
        cuentaDestin: data.cuentaDestin,
        monto: data.monto,
        fecha: data.fecha
      });
    } catch (err) {
      console.error(err);
      this.toastr.error('No se pudo cargar la cuenta');
    } finally {
      this.loading = false;
    }
  }

  async save() {
    if (this.form.invalid) {
      this.toastr.error('El formulario contiene errores');
      this.form.markAllAsTouched();
      return;
    }

    this.loading = true;
    this.form.disable();

    try {
      const v = this.form.value;

      const payload: MovementInterface = {
        uid: this.movementId,
        cuentaOrigen: v.cuentaOrigen,
        cuentaDestin: v.cuentaDestin,
        monto: v.monto,
        fecha: v.fecha ? new Date(v.fecha) : new Date()
      };

      await firstValueFrom(
        this.movementService.updateMovement(this.movementId, payload)
      );

      this.toastr.success('Cuenta actualizada correctamente');
      this.router.navigate(['movement']);
    } catch (e) {
      console.error(e);
      this.toastr.error('No se pudo actualizar la cuenta');
      this.form.enable();
    } finally {
      this.loading = false;
    }
  }

  cancel() {
    this.router.navigate(['movement']);
  }
}
