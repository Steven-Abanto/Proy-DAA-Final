import { Routes } from "@angular/router";
import { AuthGuard } from "../../core/guards/auth.guard";

export const LOANDETAILS_ROUTES: Routes = [
    {
        path: '', 
        loadComponent: () => import('./components/loanDetails.component/loanDetails.component').then(m => m.LoanDetailsComponent),
        canActivate: [AuthGuard] 
    },
    {
        path: 'list', 
        loadComponent: () => import('./components/loanDetails.component/loanDetails.component').then(m => m.LoanDetailsComponent),
        canActivate: [AuthGuard] 
    },

    {
        path: ':uid',
        loadComponent: () => import('./components/loanDetails.component/loanDetails.component').then(m => m.LoanDetailsComponent),
        canActivate: [AuthGuard]
    }
]