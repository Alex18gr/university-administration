import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable, ObservedValuesFromArray} from "rxjs";
import {CourseRegistration} from "../models/CourseRegistration";
import {Announcement} from "../models/Announcement";
import {StudentRequest} from "../models/StudentRequest";
import {StudentSemesterAverageMark} from "../models/StudentSemesterAverageMark";

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

  getAverageStudentMarks(): Observable<StudentSemesterAverageMark[]> {
    return this.http.get<StudentSemesterAverageMark[]>(this.apiUrl + 'api/students/me/course-registrations/semester-average');
  }

  getStudentNotifications(): Observable<Announcement[]> {
    return this.http.get<Announcement[]>(this.apiUrl + 'api/students/me/announcements');
  }

  getStudentRequests(): Observable<StudentRequest[]> {
    return this.http.get<StudentRequest[]>(this.apiUrl + 'api/students/me/student-applications');
  }
}
