import { DecimalPipe, NgClass } from '@angular/common';
import { Component, inject, signal } from '@angular/core';
import { LoanDetailsService } from '../../services/loanDetails.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { LoanDetailsInterface } from '../../interfaces/loanDetails.interface';

@Component({
  selector: 'app-loandetails.component',
  imports: [DecimalPipe],
  templateUrl: './loandetails.component.html',
  styleUrl: './loandetails.component.scss'
})
export class LoanDetailsComponent {
  loading: boolean = false;
  private loandetailsService = inject(LoanDetailsService);
  private router = inject(Router);
  private toastr = inject(ToastrService);
  loandetailss = signal<LoanDetailsInterface[]>([]);

  async ngOnInit() {
    this.loading = true;
    this.loandetailsService.getLoanDetailss().subscribe({
      next: (loanDetailsies) => {
        this.loandetailss.set(loanDetailsies);
        this.loading = false;
      },
      error: (err) => {
        this.toastr.error('Error al obtener estudiantes');
        console.log(err);
      }
    });
  }

  addLoanDetails() {
    this.router.navigate(['loandetails/add']);
  }

  editLoanDetails(uid: string) {
    this.router.navigate([`loandetails/update/${uid}`]);     
  }  

  goBack(){
    this.router.navigate(['dashboard']);
  }
}
