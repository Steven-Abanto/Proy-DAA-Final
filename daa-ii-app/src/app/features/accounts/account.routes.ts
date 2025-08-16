import { Routes } from "@angular/router";
import { AuthGuard } from "../../core/guards/auth.guard";

export const ACCOUNT_ROUTES: Routes = [
    {
        path: '', 
        loadComponent: () => import('./components/account.component/account.component').then(m => m.AccountComponent),
        canActivate: [AuthGuard] 
    },
    {
        path: 'list', 
        loadComponent: () => import('./components/account.component/account.component').then(m => m.AccountComponent),
        canActivate: [AuthGuard] 
    },  
    {
        path: 'add',
        loadComponent: () => import('./components/account.add.component/account.add.component').then(m => m.AccountAddComponent),
        canActivate: [AuthGuard]
    },
    {
        path: 'update/:uid',
        loadComponent: () => import('./components/account.update.component/account.update.component').then(m => m.AccountUpdateComponent),
        canActivate: [AuthGuard] 
    }      
]