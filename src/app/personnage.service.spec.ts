import { TestBed } from '@angular/core/testing';

import { PersonnageService } from './personnage.service';

describe('PersonnageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PersonnageService = TestBed.get(PersonnageService);
    expect(service).toBeTruthy();
  });
});
