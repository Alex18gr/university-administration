import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeCatalogPageComponent } from './employee-catalog-page.component';

describe('EmployeeCatalogPageComponent', () => {
  let component: EmployeeCatalogPageComponent;
  let fixture: ComponentFixture<EmployeeCatalogPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeCatalogPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeCatalogPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
