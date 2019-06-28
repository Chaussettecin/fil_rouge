import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnnemisComponent } from './ennemis.component';

describe('EnnemisComponent', () => {
  let component: EnnemisComponent;
  let fixture: ComponentFixture<EnnemisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnnemisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnnemisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
