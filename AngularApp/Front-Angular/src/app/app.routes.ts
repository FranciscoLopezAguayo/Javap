import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register/register.component';
import { LoginComponent } from './login/login/login.component';

export const routes: Routes = [
    {
        path: 'register',
        component: RegisterComponent,
      },
      {
        path: 'login',
        component: LoginComponent,
      }
   // {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
    /*{
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
        path: 'SessionStorageDemo', 
        component: SessionStorageDemoComponent
    },
    {
        path: 'not-found', 
        component: NotFoundComponent
    },*/
   // {path: '**', redirectTo: '/not-found'}
    
];
