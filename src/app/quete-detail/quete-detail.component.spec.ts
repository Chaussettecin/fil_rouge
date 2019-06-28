import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QueteDetailComponent } from './quete-detail.component';

describe('QueteDetailComponent', () => {
  let component: QueteDetailComponent;
  let fixture: ComponentFixture<QueteDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QueteDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QueteDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
