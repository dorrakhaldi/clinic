import { TestBed } from '@angular/core/testing';

import { BackendApiFormationService } from './backend-api-formation.service';

describe('BackendApiFormationService', () => {
  let service: BackendApiFormationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BackendApiFormationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
