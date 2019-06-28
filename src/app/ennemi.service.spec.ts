import { TestBed } from '@angular/core/testing';

import { EnnemiService } from './ennemi.service';

describe('EnnemiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EnnemiService = TestBed.get(EnnemiService);
    expect(service).toBeTruthy();
  });
});
