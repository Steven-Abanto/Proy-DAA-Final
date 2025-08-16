import { DecimalPipe, NgClass, DatePipe } from '@angular/common';
import { Component, inject, signal } from '@angular/core';
import { MovementService } from '../../services/movement.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MovementInterface } from '../../interfaces/movement.interface';

@Component({
  selector: 'app-movement.component',
  imports: [DecimalPipe, DatePipe],
  templateUrl: './movement.component.html',
  styleUrl: './movement.component.scss'
})
export class MovementComponent {
  loading: boolean = false;
  private movementService = inject(MovementService);
  private router = inject(Router);
  private toastr = inject(ToastrService);
  movements = signal<MovementInterface[]>([]);

  async ngOnInit() {
    this.loading = true;
    this.movementService.getMovements().subscribe({
      next: (movementies) => {
        this.movements.set(movementies);
        this.loading = false;
      },
      error: (err) => {
        this.toastr.error('Error al obtener estudiantes');
        console.log(err);
      }
    });
  }

  addMovement() {
    this.router.navigate(['movements/add']);
  }

  editMovement(uid: string) {
    this.router.navigate([`movements/update/${uid}`]);     
  }  

  goBack(){
    this.router.navigate(['dashboard']);
  }
}
