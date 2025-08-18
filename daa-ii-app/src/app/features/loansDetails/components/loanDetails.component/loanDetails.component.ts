import { DecimalPipe, NgClass } from '@angular/common';
import { Component, inject, signal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private toastr = inject(ToastrService);
  loandetailss = signal<LoanDetailsInterface | null>(null);


  async ngOnInit() {
    this.loading = true;
    const uid = this.route.snapshot.paramMap.get('uid');
    if (uid) {
      this.loandetailsService.getLoanDetailsById(uid).subscribe({
        next: (details) => {
          this.loandetailss.set(details);
          this.loading = false;
        },
        error: (err) => {
          this.toastr.error('Error al obtener detalles del préstamo');
          console.log(err);
        }
      });
    } else {
      this.toastr.warning('No se encontró el UID del préstamo');
      this.loading = false;
    }
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
