import { Routes } from '@angular/router';

export const routes: Routes = [
    { 
        path: '', 
        redirectTo: 'dashboard', pathMatch: 'full' 
    },
    { 
        path: 'dashboard', 
        loadChildren: () => import('./features/dashboard/dashboard.routes').then(m => m.DASHBOARD_ROUTES) 
    },
    {
        path: 'auth',
        loadChildren: () => import('./features/auth/auth.routes').then(m => m.AUTH_ROUTES)
    },
    {
        path: 'account',
        loadChildren: () => import('./features/accounts/account.routes').then(m => m.ACCOUNT_ROUTES)
    },
    {
        path: 'movements',
        loadChildren: () => import('./features/movements/movement.routes').then(m => m.MOVEMENT_ROUTES)
    },
    {
        path: 'loans',
        loadChildren: () => import('./features/loans/loan.routes').then(m => m.LOAN_ROUTES)
    }
];
