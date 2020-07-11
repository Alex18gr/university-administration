import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../../authentication/authentication.service";
import {AuthUserModel} from "../../authentication/models/AuthUserModel";
import {ToastService} from "../../common/toast/toast.service";

@Component({
  selector: 'app-main-application',
  templateUrl: './main-application.component.html',
  styleUrls: ['./main-application.component.scss']
})
export class MainApplicationComponent implements OnInit {
  userData: AuthUserModel;
  studentDetails: any;

  constructor(private authenticationService: AuthenticationService,
              private toastService: ToastService) { }

  ngOnInit(): void {
    this.authenticationService.checkAuth().subscribe(isAuthenticated => {
      if (isAuthenticated) {
        this.userData = this.authenticationService.getUserData();
        this.authenticationService.getCurrentStudentDetails().subscribe(data => {
          this.studentDetails = data;
        });
      }
    }, error => {
      this.toastService.addErrorToast('Πρόβλημα Φόρτωσης Δεδομένων', 'Ένα πρόβλημα προέκυψε κατά την φόρτωση δεδομένων από τον διακομιστή');
    });
  }

}
