import { Component, computed, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AccountInterface } from '../../../../features/accounts/interfaces/account.interface';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AccountService } from '../../services/account.service';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-account.update.component',
  imports: [ReactiveFormsModule],
  templateUrl: './account.update.component.html',
  styleUrl: './account.update.component.scss'
})
export class AccountUpdateComponent implements OnInit {
  form!: FormGroup;
  loading = false;
  accountId: string;
  accountData: AccountInterface | null = null;

  constructor(
    private fb: FormBuilder,
    private accountService: AccountService,
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

    this.accountId = this.route.snapshot.paramMap.get('uid')!;
  }

  async ngOnInit() {
    await this.loadAccountData();
  }

  async loadAccountData() {
    this.loading = true;
    try {
      const data = await firstValueFrom(
        this.accountService.getAccountById(this.accountId) // Observable<AccountInterface>
      );

      this.accountData = data;

      this.form.patchValue({
//        uid: this.accountId,
        nroCuenta: data.nroCuenta,
        tipoCuenta: data.tipoCuenta,
        saldo: data.saldo,
        compraInt: data.compraInt
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

      const payload: AccountInterface = {
        uid: this.accountId,
        nroCuenta: v.nroCuenta,
        tipoCuenta: v.tipoCuenta,
        saldo: v.saldo,
        compraInt: v.compraInt
      };

      await firstValueFrom(
        this.accountService.updateAccount(this.accountId, payload)
      );

      this.toastr.success('Cuenta actualizada correctamente');
      this.router.navigate(['account']);
    } catch (e) {
      console.error(e);
      this.toastr.error('No se pudo actualizar la cuenta');
      this.form.enable();
    } finally {
      this.loading = false;
    }
  }

  cancel() {
    this.router.navigate(['account']);
  }
}
