import { Routes } from "@angular/router";
import { AuthGuard } from "../../core/guards/auth.guard";

export const MOVEMENT_ROUTES: Routes = [
    {
        path: '', 
        loadComponent: () => import('./components/movement.component/movement.component').then(m => m.MovementComponent),
        canActivate: [AuthGuard] 
    },
    {
        path: 'list', 
        loadComponent: () => import('./components/movement.component/movement.component').then(m => m.MovementComponent),
        canActivate: [AuthGuard] 
    },  
    {
        path: 'add',
        loadComponent: () => import('./components/movement.add.component/movement.add.component').then(m => m.MovementAddComponent),
        canActivate: [AuthGuard]
    }
/*     ,
    {
        path: 'update/:uid',
        loadComponent: () => import('./components/movement.update.component/movement.update.component').then(m => m.MovementUpdateComponent),
        canActivate: [AuthGuard] 
    }    */   
]