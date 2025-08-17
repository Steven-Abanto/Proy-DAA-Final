import { Routes } from "@angular/router";
import { AuthGuard } from "../../core/guards/auth.guard";

export const LOAN_ROUTES: Routes = [
    {
        path: '', 
        loadComponent: () => import('./components/loan.component/loan.component').then(m => m.LoanComponent),
        canActivate: [AuthGuard] 
    },
    {
        path: 'list', 
        loadComponent: () => import('./components/loan.component/loan.component').then(m => m.LoanComponent),
        canActivate: [AuthGuard] 
    },  
    {
        path: 'add',
        loadComponent: () => import('./components/loan.add.component/loan.add.component').then(m => m.LoanAddComponent),
        canActivate: [AuthGuard]
    }
/*     ,
    {
        path: 'update/:uid',
        loadComponent: () => import('./components/loan.update.component/loan.update.component').then(m => m.LoanUpdateComponent),
        canActivate: [AuthGuard] 
    }    */   
]