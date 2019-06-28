import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnnemiSearchComponent } from './ennemi-search.component';

describe('EnnemiSearchComponent', () => {
  let component: EnnemiSearchComponent;
  let fixture: ComponentFixture<EnnemiSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnnemiSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnnemiSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
