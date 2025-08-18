import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoanDetailsInterface } from '../interfaces/loanDetails.interface';

@Injectable({
  providedIn: 'root'
})
export class LoanDetailsService {
  private apiUrl = 'http://localhost:8080/api/v1/bank/loans/details';

  constructor(private http: HttpClient) {}

  getLoanDetailss(): Observable<LoanDetailsInterface[]> {
    return this.http.get<LoanDetailsInterface[]>(this.apiUrl);
  } 

  getLoanDetailsById(uid: string): Observable<LoanDetailsInterface> {
    return this.http.get<LoanDetailsInterface>(`${this.apiUrl}/${uid}`);
  }

  createLoanDetails(loandetails: LoanDetailsInterface): Observable<LoanDetailsInterface> {
    const payload = {
      uidPrestamo: loandetails.uid_prestamo,
      uidCuenta: loandetails.uidCuenta,
      montoPrestamo: loandetails.montoPrestamo,
      tasaInt: loandetails.tasaInt,
      cuotas: loandetails.cuotas,
      deudaCuota: loandetails.deuda_cuota,
      deudaTotal: loandetails.deuda_total,
      fecha: loandetails.fecha ?? new Date()
    };
    return this.http.post<LoanDetailsInterface>(this.apiUrl, payload);
  }
  
  updateLoanDetails(id: string, loandetails: LoanDetailsInterface): Observable<LoanDetailsInterface> {
    return this.http.put<LoanDetailsInterface>(`${this.apiUrl}/${id}`, loandetails, {
      headers: { 'Content-Type': 'application/json' }
    });
  }
  
  deleteLoanDetails(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }  
}
