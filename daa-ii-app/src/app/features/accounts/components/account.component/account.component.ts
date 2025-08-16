import { DecimalPipe, NgClass } from '@angular/common';
import { Component, inject, signal } from '@angular/core';
import { AccountService } from '../../services/account.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AccountInterface } from '../../interfaces/account.interface';

@Component({
  selector: 'app-account.component',
  imports: [DecimalPipe],
  templateUrl: './account.component.html',
  styleUrl: './account.component.scss'
})
export class AccountComponent {
  loading: boolean = false;
  private accountService = inject(AccountService);
  private router = inject(Router);
  private toastr = inject(ToastrService);
  accounts = signal<AccountInterface[]>([]);

  async ngOnInit() {
    this.loading = true;
    this.accountService.getAccounts().subscribe({
      next: (accounties) => {
        this.accounts.set(accounties);
        this.loading = false;
      },
      error: (err) => {
        this.toastr.error('Error al obtener estudiantes');
        console.log(err);
      }
    });
  }

  addAccount() {
    this.router.navigate(['account/add']);
  }

  editAccount(uid: string) {
    this.router.navigate([`account/update/${uid}`]);     
  }  

  goBack(){
    this.router.navigate(['dashboard']);
  }
}
