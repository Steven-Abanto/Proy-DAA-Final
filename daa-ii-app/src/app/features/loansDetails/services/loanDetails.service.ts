import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoanDetailsInterface } from '../interfaces/loanDetails.interface';

@Injectable({
  providedIn: 'root'
})
export class LoanDetailsService {
  private apiUrl = 'http://localhost:8080/api/v1/bank/loandetailss';

  constructor(private http: HttpClient) {}

  getLoanDetailss(): Observable<LoanDetailsInterface[]> {
    return this.http.get<LoanDetailsInterface[]>(this.apiUrl);
  } 

  getLoanDetailsById(id: string): Observable<LoanDetailsInterface> {
    return this.http.get<LoanDetailsInterface>(`${this.apiUrl}/${id}`);
  }

  createLoanDetails(loandetails: LoanDetailsInterface): Observable<LoanDetailsInterface> {
    const payload = {
      uidPrestamo: loandetails.uidPrestamo,
      uidCuenta: loandetails.uidCuenta,
      montoPrestamo: loandetails.montoPrestamo,
      tasaInt: loandetails.tasaInt,
      cuotas: loandetails.cuotas,
      deudaCuota: loandetails.deudaCuota,
      deudaTotal: loandetails.deudaTotal,
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
