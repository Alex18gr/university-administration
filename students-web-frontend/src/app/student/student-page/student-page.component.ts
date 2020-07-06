import { Component, OnInit } from '@angular/core';
import * as FaIcons from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-student-page',
  templateUrl: './student-page.component.html',
  styleUrls: ['./student-page.component.scss']
})
export class StudentPageComponent implements OnInit {
  warningSingIcon = FaIcons.faExclamationTriangle;
  excelExportIcon = FaIcons.faFileExcel;
  downloadIcon = FaIcons.faDownload;

  constructor() { }

  ngOnInit(): void {
  }

}
