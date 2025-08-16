import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AccountService } from '../../services/account.service';

@Component({
  selector: 'app-account.add.component',
  imports: [ReactiveFormsModule],
  templateUrl: './account.add.component.html',
  styleUrl: './account.add.component.scss',
})
export class AccountAddComponent {
  form!: FormGroup;
  loading = false;

  constructor(
    private fb: FormBuilder,
    private accountService: AccountService,
    private router: Router,
    private toastr: ToastrService
  ) {
    this.form = this.fb.group({
      tipoCuenta: ['', Validators.required],
      compraInt: [false]
    });
  }

  async save() {
    this.loading = true;
    this.form.disable();  
    const account = this.form.value;  
    
    this.accountService.createAccount(account).subscribe({
      next: () => {
        this.toastr.success('Cuenta registrada correctamente');
        this.router.navigate(['account/list']);
      },
      error: (error) => {
        console.error('Error al registrar cuenta:', error);
        const backendMessage = error?.error?.message || 'Error al registrar cuenta';
        this.toastr.error(backendMessage);
      },
      complete: () => {
        this.form.enable();
        this.loading = false;
      }
    });   
  }

  cancel() {
    this.router.navigate(['account/list']);
  }
}
