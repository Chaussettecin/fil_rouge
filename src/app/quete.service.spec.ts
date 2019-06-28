import { TestBed } from '@angular/core/testing';

import { QueteService } from './quete.service';

describe('QueteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: QueteService = TestBed.get(QueteService);
    expect(service).toBeTruthy();
  });
});
