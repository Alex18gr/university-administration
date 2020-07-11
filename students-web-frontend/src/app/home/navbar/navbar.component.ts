import { Component, OnInit } from '@angular/core';
import * as FaIcons from '@fortawesome/free-solid-svg-icons';
import {AuthenticationService} from "../../authentication/authentication.service";
import {ActivatedRoute, Router} from "@angular/router";
import {StudentDetails} from "../../common/models/StudentDetails";
import {ToastService} from "../../common/toast/toast.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  notificationIcon = FaIcons.faBell;
  userIcon = FaIcons.faUserCircle;
  studentsData: StudentDetails;

  constructor(private authenticationService: AuthenticationService,
              private toastService: ToastService) { }

  ngOnInit(): void {
    this.authenticationService.getCurrentStudentDetails().subscribe((data: StudentDetails) => {
      this.studentsData = data;
    }, error => {
      this.toastService.addErrorToast('Πρόβλημα Φόρτωσης Δεδομένων', 'Ένα πρόβλημα προέκυψε κατά την φόρτωση δεδομένων από τον διακομιστή');
    });
  }

  logoutUser() {
    this.authenticationService.logout();
  }


}
