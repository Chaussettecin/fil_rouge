import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnnemiDetailComponent } from './ennemi-detail.component';

describe('EnnemiDetailComponent', () => {
  let component: EnnemiDetailComponent;
  let fixture: ComponentFixture<EnnemiDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnnemiDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnnemiDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
