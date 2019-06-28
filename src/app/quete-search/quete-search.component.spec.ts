import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QueteSearchComponent } from './quete-search.component';

describe('QueteSearchComponent', () => {
  let component: QueteSearchComponent;
  let fixture: ComponentFixture<QueteSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QueteSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QueteSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
