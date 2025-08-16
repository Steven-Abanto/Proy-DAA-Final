import { TestBed } from '@angular/core/testing';

import { MovementService } from './movement.service';

describe('MovementServices', () => {
  let service: MovementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
