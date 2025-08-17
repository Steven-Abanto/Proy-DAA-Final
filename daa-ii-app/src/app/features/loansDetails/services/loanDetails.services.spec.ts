import { TestBed } from '@angular/core/testing';

import { LoanDetailsService } from './loanDetails.service';

describe('LoanDetailsServices', () => {
  let service: LoanDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoanDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
