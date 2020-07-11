import { TestBed } from '@angular/core/testing';

import { StudentChartService } from './student-chart.service';

describe('StudentChartService', () => {
  let service: StudentChartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentChartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
