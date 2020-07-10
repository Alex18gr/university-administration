import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {Department} from "../models/Department";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  apiUrl: string = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getAllDepartments(): Observable<Department[]> {
    return this.http.get<Department[]>(this.apiUrl + 'api/departments');
  }

}
