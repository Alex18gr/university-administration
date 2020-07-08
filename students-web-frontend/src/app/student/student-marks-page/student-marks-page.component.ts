import {Component, Input, OnInit} from '@angular/core';
import * as FaIcons from "@fortawesome/free-solid-svg-icons";
import {StudentService} from "../../common/service/student.service";
import {CourseRegistration} from "../../common/models/CourseRegistration";
import {StudentDetails} from "../../common/models/StudentDetails";

@Component({
  selector: 'app-student-marks-page',
  templateUrl: './student-marks-page.component.html',
  styleUrls: ['./student-marks-page.component.scss']
})
export class StudentMarksPageComponent implements OnInit {
  @Input() studentData: StudentDetails;
  excelExportIcon = FaIcons.faFileExcel;
  downloadIcon = FaIcons.faDownload;
  loadingData: boolean = false;
  studentMarks: CourseRegistration[];
  selectedSemester: number = 8;

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.initializeUserData();
    this.getStudentMarks();
  }

  initializeUserData() {
    this.selectedSemester = this.studentData.semester;
  }

  getStudentMarks() {
    this.loadingData = true;
    this.studentService.getStudentMarks(this.selectedSemester).subscribe((marksData) => {
      this.studentMarks = marksData;
      this.loadingData = false;
    });
  }

  onSemesterSelectChange(event: any) {
    this.selectedSemester = event.target.value;
    this.getStudentMarks();
  }
}
