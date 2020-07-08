import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {CourseRegistration} from "../models/CourseRegistration";
import {Announcement} from "../models/Announcement";

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  apiUrl: string = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getStudentMarks(semester: number): Observable<CourseRegistration[]> {
    return this.http.get<CourseRegistration[]>(this.apiUrl + 'api/students/me/course-registrations',
      {params: new HttpParams().set('semester', semester.toString())});
  }

  getStudentNotifications(): Observable<Announcement[]> {
    return this.http.get<Announcement[]>(this.apiUrl + 'api/students/me/announcements');
  }
}
