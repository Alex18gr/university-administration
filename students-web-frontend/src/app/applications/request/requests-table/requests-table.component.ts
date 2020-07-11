import { Component, OnInit } from '@angular/core';
import {StudentRequest} from "../../../common/models/StudentRequest";
import {StudentService} from "../../../common/service/student.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ToastService} from "../../../common/toast/toast.service";

@Component({
  selector: 'app-requests-table',
  templateUrl: './requests-table.component.html',
  styleUrls: ['./requests-table.component.scss']
})
export class RequestsTableComponent implements OnInit {
  requests: StudentRequest[];
  requestsLoaded: boolean = false;

  constructor(private studentService: StudentService,
              private router: Router,
              private route: ActivatedRoute,
              private toastService: ToastService) { }

  ngOnInit(): void {

    this.loadRequestsData();

  }

  loadRequestsData() {
    this.studentService.getStudentRequests().subscribe(data => {
      this.requests = data;
      this.requestsLoaded = true;
    }, error => {
      this.toastService.addErrorToast('Πρόβλημα Φόρτωσης Δεδομένων', 'Ένα πρόβλημα προέκυψε κατά την φόρτωση δεδομένων από τον διακομιστή');
      this.requestsLoaded = false;
    });
  }

  onNewRequestClicked() {
    this.router.navigate(['new-request'], {relativeTo: this.route});
  }
}
