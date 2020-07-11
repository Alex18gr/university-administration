import { Injectable } from '@angular/core';
import * as XLSX from 'xlsx';
import {CourseRegistration} from "../models/CourseRegistration";
import {mark} from "@angular/compiler-cli/src/ngtsc/perf/src/clock";

@Injectable({
  providedIn: 'root'
})
export class SheetExportService {

  constructor() { }

  exportStudentMarksToExcel(marksArray: CourseRegistration[]) {

    const heading: string[][] = [
      ['Κωδικός Μαθήματος', 'Όνομα Μαθήματος', 'Βαθμός']
    ];
    const marks: any[] = SheetExportService.mapCourseMarks(marksArray);

    const fileName = 'marks.xlsx';

    const ws: XLSX.WorkSheet = XLSX.utils.aoa_to_sheet(heading);// XLSX.utils.json_to_sheet(marks);
    XLSX.utils.sheet_add_json(ws, marks, {skipHeader: true, origin: "A2"});
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'test');

    XLSX.writeFile(wb, fileName);
  }

  private static mapCourseMarks(marksArray: CourseRegistration[]) {
    const marks: any[] = [];
    for(let m of marksArray) {
      marks.push({
        registryNumber: m.registryNumber,
        name: m.name,
        mark: m.mark
      });
    }
    return marks;
  }
}
