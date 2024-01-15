import { Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LoginComponent } from './auth/login/login.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { HomeComponent } from './pages/home/home.component';
import { ProfileComponent } from './auth/profile/profile/profile.component';

export const routes: Routes = [
    {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
    {
        path: 'login', 
        component: LoginComponent
    },
    {
        path: 'dashboard', 
        component: DashboardComponent
    },
    {
        path: 'home', 
        component: HomeComponent
    },
    {
        path: 'profile', 
        component: ProfileComponent
    },
    {
        path: 'not-found', 
        component: NotFoundComponent
    },
    {path: '**', redirectTo: '/not-found'}
    
];
