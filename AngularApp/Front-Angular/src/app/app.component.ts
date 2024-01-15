import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LoginComponent } from './auth/login/login.component';
import { NavComponent } from './shared/nav/nav.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  //imports: [CommonModule, RouterOutlet, UsersComponent], // aqui importar el componente cuando se quiera usar el componente en el app principal
  imports: [
    // aqui importar el componente cuando se quiera usar el componente en el app principal
    CommonModule, 
    RouterOutlet, 
    HeaderComponent, 
    FooterComponent, 
    DashboardComponent, 
    LoginComponent,
    NavComponent
    ], 
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'VARIABLE DEL Front-Angular';
  saludo = 'Saludos desde angular';
}
