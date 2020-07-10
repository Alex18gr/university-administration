import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeCatalogSearchFormComponent } from './employee-catalog-search-form.component';

describe('EmployeeCatalogSearchFormComponent', () => {
  let component: EmployeeCatalogSearchFormComponent;
  let fixture: ComponentFixture<EmployeeCatalogSearchFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeCatalogSearchFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeCatalogSearchFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
