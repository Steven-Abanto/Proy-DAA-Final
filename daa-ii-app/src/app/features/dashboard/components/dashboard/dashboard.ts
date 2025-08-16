import { Component, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SessionService } from '../../../../core/services/session.service';

@Component({
  selector: 'app-dashboard',
  imports: [RouterModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss'
})
export class Dashboard {
  private sessionService = inject(SessionService);

  onLogout() {
    this.sessionService['logout']();
  }

}
