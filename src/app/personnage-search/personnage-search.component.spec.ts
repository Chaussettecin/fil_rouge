import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonnageSearchComponent } from './personnage-search.component';

describe('PersonnageSearchComponent', () => {
  let component: PersonnageSearchComponent;
  let fixture: ComponentFixture<PersonnageSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonnageSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonnageSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
