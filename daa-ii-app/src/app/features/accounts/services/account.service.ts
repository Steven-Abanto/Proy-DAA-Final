import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccountInterface } from '../interfaces/account.interface';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private apiUrl = 'http://localhost:8080/api/v1/bank/accounts';

  constructor(private http: HttpClient) {}

  getAccounts(): Observable<AccountInterface[]> {
    return this.http.get<AccountInterface[]>(this.apiUrl);
  } 

  getAccountById(id: string): Observable<AccountInterface> {
    return this.http.get<AccountInterface>(`${this.apiUrl}/${id}`);
  }

  createAccount(account: AccountInterface): Observable<AccountInterface> {
    const payload = {
      tipoCuenta: account.tipoCuenta,
      compraInt: account.compraInt ?? false,
      saldo: account.saldo ?? 0
    };
    return this.http.post<AccountInterface>(this.apiUrl, payload);
  }
  
  updateAccount(id: string, account: AccountInterface): Observable<AccountInterface> {
    return this.http.put<AccountInterface>(`${this.apiUrl}/${id}`, account, {
      headers: { 'Content-Type': 'application/json' }
    });
  }
  
  deleteAccount(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }  
}
