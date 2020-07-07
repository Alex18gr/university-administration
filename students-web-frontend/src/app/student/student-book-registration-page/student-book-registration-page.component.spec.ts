import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentBookRegistrationPageComponent } from './student-book-registration-page.component';

describe('StudentBookRegistrationPageComponent', () => {
  let component: StudentBookRegistrationPageComponent;
  let fixture: ComponentFixture<StudentBookRegistrationPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentBookRegistrationPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentBookRegistrationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
