import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonnageDetailComponent } from './personnage-detail.component';

describe('PersonnageDetailComponent', () => {
  let component: PersonnageDetailComponent;
  let fixture: ComponentFixture<PersonnageDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonnageDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonnageDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
