import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(
    private http: HttpClient
  ) { }

  create(): Observable<any> {
    return this.http.post("http://localhost:8080/account", null);
  }

  findAll(): Observable<any> {
    return this.http.get("http://localhost:8080/account");
  }
}
