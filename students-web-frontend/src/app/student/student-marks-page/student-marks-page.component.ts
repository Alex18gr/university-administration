import { Component, OnInit } from '@angular/core';
import * as FaIcons from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-student-marks-page',
  templateUrl: './student-marks-page.component.html',
  styleUrls: ['./student-marks-page.component.scss']
})
export class StudentMarksPageComponent implements OnInit {
  excelExportIcon = FaIcons.faFileExcel;
  downloadIcon = FaIcons.faDownload;

  constructor() { }

  ngOnInit(): void {
  }

}
