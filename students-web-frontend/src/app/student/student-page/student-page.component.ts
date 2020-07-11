import { Component, OnInit } from '@angular/core';
import * as FaIcons from '@fortawesome/free-solid-svg-icons';
import {AuthenticationService} from "../../authentication/authentication.service";
import {StudentDetails} from "../../common/models/StudentDetails";
import {ToastService} from "../../common/toast/toast.service";

@Component({
  selector: 'app-student-page',
  templateUrl: './student-page.component.html',
  styleUrls: ['./student-page.component.scss']
})
export class StudentPageComponent implements OnInit {
  warningSingIcon = FaIcons.faExclamationTriangle;

  selectedTab: string = 'marks';
  studentData: StudentDetails;
  dataLoading: boolean = true;

  constructor(private authenticationService: AuthenticationService,
              private toastService: ToastService) { }

  ngOnInit(): void {
    this.loadUserData();
  }

  loadUserData(): void {
    this.dataLoading = true;
    this.authenticationService.getCurrentStudentDetails().subscribe((data: StudentDetails) => {
      this.studentData = data;
      this.dataLoading = false;
    }, error => {
      this.toastService.addErrorToast('Πρόβλημα Φόρτωσης Δεδομένων', 'Ένα πρόβλημα προέκυψε κατά την φόρτωση δεδομένων από τον διακομιστή');
      this.dataLoading = false;
    });
  }

  setActiveTab(tabName: string) {
    this.selectedTab = tabName;
  }
}
