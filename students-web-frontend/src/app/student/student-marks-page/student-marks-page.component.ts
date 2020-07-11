import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import * as FaIcons from "@fortawesome/free-solid-svg-icons";
import {StudentService} from "../../common/service/student.service";
import {CourseRegistration} from "../../common/models/CourseRegistration";
import {StudentDetails} from "../../common/models/StudentDetails";
import * as Chart from 'chart.js';
import {forkJoin} from "rxjs";
import {StudentSemesterAverageMark} from "../../common/models/StudentSemesterAverageMark";
import {StudentChartService} from "../../common/service/student-chart.service";
import {SheetExportService} from "../../common/service/sheet-export.service";

@Component({
  selector: 'app-student-marks-page',
  templateUrl: './student-marks-page.component.html',
  styleUrls: ['./student-marks-page.component.scss']
})
export class StudentMarksPageComponent implements OnInit {
  @ViewChild('marksChart') marksChartElement: ElementRef;
  @ViewChild('semesterMarksChart') semesterMarksChartElement: ElementRef;
  @Input() studentData: StudentDetails;
  excelExportIcon = FaIcons.faFileExcel;
  downloadIcon = FaIcons.faDownload;
  loadingData: boolean = false;
  studentMarks: CourseRegistration[];
  studentAverageMarks: StudentSemesterAverageMark[];
  selectedSemester: number = 8;

  chart: Chart;
  private marksChart: Chart;
  private semesterMarksChart: Chart;

  constructor(private studentService: StudentService,
              private studentChartService: StudentChartService,
              private sheetExportService: SheetExportService) { }

  ngOnInit(): void {
    this.initializeUserData();
    this.getStudentMarks();
  }

  initializeUserData() {
    this.selectedSemester = this.studentData.semester;
  }

  getStudentMarks() {
    this.loadingData = true;
    forkJoin({
      studentMarks: this.studentService.getStudentMarks(this.selectedSemester),
      studentAverageMarks: this.studentService.getAverageStudentMarks()
    })
    .subscribe((data) => {
      this.studentMarks = data.studentMarks;
      this.studentAverageMarks = data.studentAverageMarks;
      this.createMarksChart();
      this.createAverageSemesterMarksChart();
      this.loadingData = false;
    });
  }

  onSemesterSelectChange(event: any) {
    this.selectedSemester = event.target.value;
    this.getStudentMarks();
  }

  createAverageSemesterMarksChart() {
    if (this.semesterMarksChart) {
      this.semesterMarksChart.destroy();
    }
    this.semesterMarksChart = this.studentChartService.getSemesterStudentMarksChart(this.studentAverageMarks, this.semesterMarksChartElement);
  }

  createMarksChart() {
    if (this.marksChart) {
      this.marksChart.destroy();
    }
    this.marksChart = this.studentChartService.getMarksChart(this.studentMarks, this.marksChartElement);
  }

  exportCurrentMarksToExcel() {
    this.sheetExportService.exportStudentMarksToExcel(this.studentMarks);
  }

}
