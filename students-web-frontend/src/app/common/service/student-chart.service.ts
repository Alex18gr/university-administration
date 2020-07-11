import {ElementRef, Injectable} from '@angular/core';
import {StudentSemesterAverageMark} from "../models/StudentSemesterAverageMark";
import * as Chart from 'chart.js';
import {CourseRegistration} from "../models/CourseRegistration";

@Injectable({
  providedIn: 'root'
})
export class StudentChartService {

  constructor() { }

  getMarksChart(studentMarks: CourseRegistration[], element: ElementRef) {

    const marksData: number[] = [0, 0, 0];
    for (let m of studentMarks) {
      if (m.mark >= 8.5) {
        marksData[2] += 1;
      } else if (m.mark >= 7.5) {
        marksData[1] += 1;
      } else if (m.mark >= 5) {
        marksData[0] += 1;
      }
    }


    const data = {
      datasets: [{
        data: marksData,
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(54, 162, 235, 0.2)',

          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)'
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(54, 162, 235, 1)',

          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)'
        ],
        borderWidth: 1
      }],
      labels: [
        '5 - 7.5',
        '7.5 - 8.5',
        '8.5 - 10'
      ]
    };
    return new Chart(element.nativeElement, {
      type: 'pie',
      data: data,
      options: {
        title: {
          display: true,
          text: 'Κατανομή Βαθμολογίας Περασμένων Μαθημάτων'
        }
      }

    });
  }

  getSemesterStudentMarksChart(studentAverageMarks: StudentSemesterAverageMark[], element: ElementRef) {

    const labels: string[] = [];
    const data: number[] = [];

    for (let d of studentAverageMarks) {
      labels.push(d.semester + 'ο Εξάμηνο')
      data.push(d.marksAverage);
    }

    return new Chart(element.nativeElement, {
      type: 'bar',
      data: {
        labels: labels,
        datasets: [{
          label: 'Μέση Βαθμολογία',
          data,
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        legend: {
          display: false
        },
        title: {
          display: true,
          text: 'Μέση Βαθμολογία ανα Εξάμηνο'
        },
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
    });
  }
}
