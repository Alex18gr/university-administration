import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import * as FaIcons from "@fortawesome/free-solid-svg-icons";
import {FormControl, FormGroup} from "@angular/forms";
import {DepartmentService} from "../../../common/service/department.service";
import {EmployeeService} from "../../../common/service/employee.service";
import {forkJoin} from "rxjs";
import {RequestService} from "../../../common/service/request.service";
import {Department} from "../../../common/models/Department";
import {RequestAuthority} from "../../../common/models/RequestAuthority";

@Component({
  selector: 'app-employee-catalog-search-form',
  templateUrl: './employee-catalog-search-form.component.html',
  styleUrls: ['./employee-catalog-search-form.component.scss']
})
export class EmployeeCatalogSearchFormComponent implements OnInit {
  @Output('formSubmitted') fromSubmitted: EventEmitter<any> = new EventEmitter<any>();
  searchIcon = FaIcons.faSearch;
  filterIcon = FaIcons.faFilter;
  loadingData: boolean = false;
  formDataLoaded: boolean = false;
  departments: Department[];
  universityServices: RequestAuthority[];

  employeeSearchForm: FormGroup;

  constructor(private departmentService: DepartmentService,
              private employeeService: EmployeeService,
              private requestService: RequestService) { }

  ngOnInit(): void {
    this.loadFormData();
  }

  initializeForm() {
    this.employeeSearchForm = new FormGroup({
      text: new FormControl(''),
      departmentId: new FormControl(''),
      serviceId: new FormControl('')
    });
    this.employeeSearchForm.patchValue({
      text: '',
      departmentId: null,
      serviceId: null
    });
  }

  private loadFormData() {
    this.loadingData = true;
    this.formDataLoaded = false;
    forkJoin({
      departments: this.departmentService.getAllDepartments(),
      universityServices: this.requestService.getAllUniversityServices()
    }).subscribe(data => {

      this.departments = data.departments;
      this.universityServices = data.universityServices;
      this.initializeForm();
      this.submitSearchForm();

      this.loadingData = false;
      this.formDataLoaded = true;
    }, error => {
      this.loadingData = false;
    });
  }

  submitSearchForm() {
    this.fromSubmitted.emit(this.employeeSearchForm.getRawValue());
  }
}
