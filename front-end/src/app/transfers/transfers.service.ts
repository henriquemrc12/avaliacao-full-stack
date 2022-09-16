import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransfersService {

  constructor(
    private http: HttpClient
  ) { }

  create(body: any): Observable<any> {
    return this.http.post("http://localhost:8080/transfer", body);
  }

  findAll(): Observable<any> {
    return this.http.get("http://localhost:8080/transfer");
  }

  findFees(amount: any, date: any): Observable<any> {
    return this.http.get(`http://localhost:8080/transfer/fee-amount?amount=${amount}&scheduleDate=${date}`);
  }

}