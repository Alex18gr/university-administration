import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentCourseRegistrationPageComponent } from './student-course-registration-page.component';

describe('StudentCourseRegistrationPageComponent', () => {
  let component: StudentCourseRegistrationPageComponent;
  let fixture: ComponentFixture<StudentCourseRegistrationPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentCourseRegistrationPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentCourseRegistrationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
