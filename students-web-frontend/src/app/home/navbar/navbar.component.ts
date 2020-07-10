import { Component, OnInit } from '@angular/core';
import * as FaIcons from '@fortawesome/free-solid-svg-icons';
import {AuthenticationService} from "../../authentication/authentication.service";
import {ActivatedRoute, Router} from "@angular/router";
import {StudentDetails} from "../../common/models/StudentDetails";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  notificationIcon = FaIcons.faBell;
  userIcon = FaIcons.faUserCircle;
  studentsData: StudentDetails;

  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
    this.authenticationService.getCurrentStudentDetails().subscribe((data: StudentDetails) => {
      this.studentsData = data;
    });
  }

  logoutUser() {
    this.authenticationService.logout();
  }


}
