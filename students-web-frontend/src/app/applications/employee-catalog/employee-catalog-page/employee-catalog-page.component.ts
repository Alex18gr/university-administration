import { Component, OnInit } from '@angular/core';
import * as FaIcons from '@fortawesome/free-solid-svg-icons';
import {EmployeeService} from "../../../common/service/employee.service";
import {Employee} from "../../../common/models/Employee";
import {ToastService} from "../../../common/toast/toast.service";

@Component({
  selector: 'app-employee-catalog-page',
  templateUrl: './employee-catalog-page.component.html',
  styleUrls: ['./employee-catalog-page.component.scss']
})
export class EmployeeCatalogPageComponent implements OnInit {
  userDefaultPictureIcon = FaIcons.faUserCircle;
  mailIcon = FaIcons.faEnvelope;
  phoneIcon = FaIcons.faPhone;
  employeeSearchResults: Employee[] = [];

  constructor(private employeeService: EmployeeService,
              private toastService: ToastService) { }

  ngOnInit(): void {

  }

  searchFormSubmitted(searchCriteria: any) {
    this.employeeService.searchEmployeeByCriteria(searchCriteria).subscribe(data => {
      this.employeeSearchResults = data;
    }, error => {
      this.toastService.addErrorToast('Πρόβλημα Φόρτωσης Δεδομένων', 'Ένα πρόβλημα προέκυψε κατά την φόρτωση δεδομένων από τον διακομιστή');
    });
  }
}
