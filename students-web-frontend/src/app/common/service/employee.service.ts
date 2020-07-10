import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../models/Employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  apiUrl: string = environment.apiUrl;

  constructor(private http: HttpClient) { }

  searchEmployeeByCriteria(criteria: any): Observable<Employee[]> {
    return this.http.post<Employee[]>(this.apiUrl + 'api/employees/search', criteria);
  }

}
