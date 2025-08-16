import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MovementInterface } from '../interfaces/movement.interface';

@Injectable({
  providedIn: 'root'
})
export class MovementService {
  private apiUrl = 'http://localhost:8080/api/v1/bank/movements';

  constructor(private http: HttpClient) {}

  getMovements(): Observable<MovementInterface[]> {
    return this.http.get<MovementInterface[]>(this.apiUrl);
  } 

  getMovementById(id: string): Observable<MovementInterface> {
    return this.http.get<MovementInterface>(`${this.apiUrl}/${id}`);
  }

  createMovement(movement: MovementInterface): Observable<MovementInterface> {
    const payload = {
      cuentaOrigen: movement.cuentaOrigen,
      cuentaDestin: movement.cuentaDestin,
      monto: movement.monto ?? 0,
      fecha: movement.fecha ? new Date(movement.fecha) : new Date()
    };
    return this.http.post<MovementInterface>(this.apiUrl, payload);
  }
  
  updateMovement(id: string, movement: MovementInterface): Observable<MovementInterface> {
    return this.http.put<MovementInterface>(`${this.apiUrl}/${id}`, movement, {
      headers: { 'Content-Type': 'application/json' }
    });
  }
  
  deleteMovement(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }  
}
