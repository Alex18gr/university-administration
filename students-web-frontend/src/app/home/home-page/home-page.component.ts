import { Component, OnInit } from '@angular/core';
import {AuthUserModel} from "../../authentication/models/AuthUserModel";
import {AuthenticationService} from "../../authentication/authentication.service";
import * as FaIcons from '@fortawesome/free-solid-svg-icons';
import {ActivatedRoute, Router} from "@angular/router";
import {StudentDetails} from "../../common/models/StudentDetails";
import {StudentService} from "../../common/service/student.service";
import {Announcement} from "../../common/models/Announcement";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  userData: AuthUserModel;
  studentDetails: StudentDetails;
  studentDataLoaded: boolean = false;

  announcements: Announcement[];
  announcementsLoaded: boolean = false;

  studentPageIcon = FaIcons.faAddressCard;
  classWebIcon = FaIcons.faGraduationCap;

  constructor(private authenticationService: AuthenticationService,
              private router: Router,
              private route: ActivatedRoute,
              private studentService: StudentService) { }

  ngOnInit(): void {
    this.checkUserAuthenticated();
  }

  checkUserAuthenticated() {
    this.authenticationService.checkAuth().subscribe(isAuthenticated => {
      if (isAuthenticated) {
        this.userData = this.authenticationService.getUserData();
        this.loadStudentDetails();
        this.loadStudentAnnouncements();
      }
    });
  }

  loadStudentDetails() {
    this.studentDataLoaded = false;
    this.authenticationService.getCurrentStudentDetails().subscribe(data => {
      this.studentDetails = data;
      this.studentDataLoaded = true;
    });
  }

  loadStudentAnnouncements() {
    this.announcementsLoaded = false;
    this.studentService.getStudentNotifications().subscribe(data => {
      this.announcements = data;
      this.announcementsLoaded = true;
    });
  }

  navigateTo(page: string) {
    this.router.navigate([page], {relativeTo: this.route});
  }

}
