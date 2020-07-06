import { Component, OnInit } from '@angular/core';
import {AuthUserModel} from "../../authentication/models/AuthUserModel";
import {AuthenticationService} from "../../authentication/authentication.service";
import * as FaIcons from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  userData: AuthUserModel;
  studentDetails: any;

  studentPageIcon = FaIcons.faAddressCard;
  classWebIcon = FaIcons.faGraduationCap;

  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
    this.authenticationService.checkAuth().subscribe(isAuthenticated => {
      if (isAuthenticated) {
        this.userData = this.authenticationService.getUserData();
        this.authenticationService.getCurrentStudentDetails().subscribe(data => {
          this.studentDetails = data;
        });
      }
    });
  }

}
