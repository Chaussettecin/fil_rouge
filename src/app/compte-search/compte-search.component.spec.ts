import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteSearchComponent } from './compte-search.component';

describe('CompteSearchComponent', () => {
  let component: CompteSearchComponent;
  let fixture: ComponentFixture<CompteSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompteSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompteSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
