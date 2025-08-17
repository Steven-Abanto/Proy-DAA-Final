import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoanInterface } from '../interfaces/loan.interface';
import { PrestamoConDetalles } from '../models/loan-with-details.dto';


@Injectable({
  providedIn: 'root'
})
export class LoanService {
  private apiUrl = 'http://localhost:8082/api/v1/bank/loans';

  constructor(private http: HttpClient) {}

  getLoans(): Observable<LoanInterface[]> {
    return this.http.get<LoanInterface[]>(this.apiUrl);
  } 

  getLoanById(id: string): Observable<LoanInterface> {
    return this.http.get<LoanInterface>(`${this.apiUrl}/${id}`);
  }

  createLoan(loan: LoanInterface): Observable<LoanInterface> {
    const payload = {
      tipoPrestamo: loan.tipoPrestamo,
      monto: loan.monto ?? 0,
      fecha: loan.fecha ? new Date(loan.fecha) : new Date()
    };
    return this.http.post<LoanInterface>(this.apiUrl, payload);
  }

  createLoanConDetalles(payload: PrestamoConDetalles): Observable<any> {
    return this.http.post(`${this.apiUrl}/con-detalles`, payload, {
      headers: { 'Content-Type': 'application/json' }
    });
  }

  updateLoan(id: string, loan: LoanInterface): Observable<LoanInterface> {
    return this.http.put<LoanInterface>(`${this.apiUrl}/${id}`, loan, {
      headers: { 'Content-Type': 'application/json' }
    });
  }
  
  deleteLoan(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }  
}
