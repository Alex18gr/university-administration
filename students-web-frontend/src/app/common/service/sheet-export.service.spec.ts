import { TestBed } from '@angular/core/testing';

import { SheetExportService } from './sheet-export.service';

describe('SheetExportService', () => {
  let service: SheetExportService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SheetExportService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
