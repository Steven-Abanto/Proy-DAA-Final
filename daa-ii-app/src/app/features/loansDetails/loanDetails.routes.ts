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
    }
/*     {
        path: 'update/:uid',
        loadComponent: () => import('./components/loandetails.update.component/loandetails.update.component').then(m => m.LoanDetailsUpdateComponent),
        canActivate: [AuthGuard] 
    }       */
]