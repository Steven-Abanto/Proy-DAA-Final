import { DecimalPipe, NgClass, DatePipe } from '@angular/common';
import { Component, inject, signal } from '@angular/core';
import { LoanService } from '../../services/loan.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { LoanInterface } from '../../interfaces/loan.interface';

@Component({
  selector: 'app-loan.component',
  imports: [DecimalPipe, DatePipe],
  templateUrl: './loan.component.html',
  styleUrl: './loan.component.scss'
})
export class LoanComponent {
  loading: boolean = false;
  private loanService = inject(LoanService);
  private router = inject(Router);
  private toastr = inject(ToastrService);
  loans = signal<LoanInterface[]>([]);

  async ngOnInit() {
    this.loading = true;
    this.loanService.getLoans().subscribe({
      next: (loanies) => {
        this.loans.set(loanies);
        this.loading = false;
      },
      error: (err) => {
        this.toastr.error('Error al obtener estudiantes');
        console.log(err);
      }
    });
  }

  addLoan() {
    this.router.navigate(['loans/add']);
  }

/*   editLoan(uid: string) {
    this.router.navigate([`loans/update/${uid}`]);     
  }  */ 

  viewLoanDetails(uid: string) {
    this.router.navigate([`loans/details/${uid}`]);
  }

  goBack(){
    this.router.navigate(['dashboard']);
  }
}
