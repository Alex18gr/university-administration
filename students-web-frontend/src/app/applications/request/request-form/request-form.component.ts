import { Component, OnInit } from '@angular/core';
import {RequestService} from "../../../common/service/request.service";
import {RequestAuthority} from "../../../common/models/RequestAuthority";
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ToastService} from "../../../common/toast/toast.service";

@Component({
  selector: 'app-request-form',
  templateUrl: './request-form.component.html',
  styleUrls: ['./request-form.component.scss']
})
export class RequestFormComponent implements OnInit {
  requestAuthorities: RequestAuthority[];
  selectedRequestAuthority: RequestAuthority;
  requestDataLoading: boolean = false;
  requestDataLoaded: boolean = false;
  submittingForm: boolean = false;

  requestForm: FormGroup;

  constructor(private requestService: RequestService,
              private router: Router,
              private route: ActivatedRoute,
              private toastService: ToastService) { }

  ngOnInit(): void {
    this.initializeForm();
    this.loadRequestAuthoritiesAndTypes();
  }

  loadRequestAuthoritiesAndTypes() {
    this.requestDataLoading = true;
    this.requestService.getRequestAuthoritiesAndTypes().subscribe(data => {
      this.requestAuthorities = data;
      this.selectedRequestAuthority = this.requestAuthorities[0];
      this.requestDataLoading = false;
      this.requestDataLoaded = true;
    }, error => {
      this.toastService.addErrorToast('Πρόβλημα Φόρτωσης Δεδομένων', 'Ένα πρόβλημα προέκυψε κατά την φόρτωση δεδομένων από τον διακομιστή');
      this.requestDataLoading = false;
    })

  }

  selectedRequestAUthorityChenged(selection: any) {
    this.selectedRequestAuthority = this.requestAuthorities[selection.target.value];
  }

  initializeForm() {
    this.requestForm = new FormGroup({
      applicationTypeId: new FormControl(''),
      notes: new FormControl('')
    });
    this.requestForm.patchValue({
      applicationTypeId: -1,
      notes: ''
    });
  }

  onRequestSubmit() {
    this.submittingForm = true;
    if (this.checkFormValid()) {
      this.requestService.createNewRequest(this.requestForm.getRawValue()).subscribe(data => {
        this.submittingForm = false;
        this.router.navigate(["../"], {relativeTo: this.route});
      }, error => {
        this.toastService.addErrorToast('Πρόβλημα Αιτήματος', 'Ένα πρόβλημα προέκυψε κατά την δημιουργία του αιτήματος στον διακομιστή');
        this.submittingForm = false;
      });
    } else {
      this.toastService.addErrorToast('Πρόβλημα Αίτησης', 'Ο τύπος πιστοποιητικού δε μπορεί να είναι κενός')
    }

  }

  checkFormValid(): boolean {
    return this.requestForm.getRawValue().applicationTypeId !== -1;
  }

  onFormReset() {
    this.requestForm.reset();
    this.requestForm.patchValue({
      applicationTypeId: -1,
      notes: ''
    });
  }
}
