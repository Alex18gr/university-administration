import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentMarksPageComponent } from './student-marks-page.component';

describe('StudentMarksPageComponent', () => {
  let component: StudentMarksPageComponent;
  let fixture: ComponentFixture<StudentMarksPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentMarksPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentMarksPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
