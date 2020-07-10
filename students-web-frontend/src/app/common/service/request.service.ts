import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {RequestAuthority} from "../models/RequestAuthority";

@Injectable({
  providedIn: 'root'
})
export class RequestService {
  apiUrl: string = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getAllUniversityServices(): Observable<RequestAuthority[]> {
    return this.http.get<RequestAuthority[]>(this.apiUrl + 'api/university-services');
  }

  getRequestAuthoritiesAndTypes(): Observable<RequestAuthority[]> {
    return this.http.get<RequestAuthority[]>(this.apiUrl + 'api/university-services/application-types');
  }

  createNewRequest(requestData: any) {
    return this.http.post<any>(this.apiUrl + 'api/students/me/student-applications', requestData);
  }

}
