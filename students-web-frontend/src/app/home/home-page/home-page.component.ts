import { Component, OnInit } from '@angular/core';
import {AuthUserModel} from "../../authentication/models/AuthUserModel";
import {AuthenticationService} from "../../authentication/authentication.service";
import * as FaIcons from '@fortawesome/free-solid-svg-icons';
import {ActivatedRoute, Router} from "@angular/router";
import {StudentDetails} from "../../common/models/StudentDetails";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  userData: AuthUserModel;
  studentDetails: StudentDetails;
  studentDataLoaded: boolean = false;

  studentPageIcon = FaIcons.faAddressCard;
  classWebIcon = FaIcons.faGraduationCap;

  constructor(private authenticationService: AuthenticationService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.authenticationService.checkAuth().subscribe(isAuthenticated => {
      if (isAuthenticated) {
        this.userData = this.authenticationService.getUserData();
        this.authenticationService.getCurrentStudentDetails().subscribe(data => {
          this.studentDetails = data;
          this.studentDataLoaded = true;
        });
      }
    });
  }

  navigateTo(page: string) {
    this.router.navigate([page], {relativeTo: this.route});
  }

}
