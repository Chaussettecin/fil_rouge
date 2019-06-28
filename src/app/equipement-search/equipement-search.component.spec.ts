import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipementSearchComponent } from './equipement-search.component';

describe('EquipementSearchComponent', () => {
  let component: EquipementSearchComponent;
  let fixture: ComponentFixture<EquipementSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquipementSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipementSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
