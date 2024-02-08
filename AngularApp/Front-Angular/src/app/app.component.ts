import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AuthService } from './services/auth.service';
import { LoginComponent } from './login/login/login.component';
import { register } from 'module';
import { RegisterComponent } from './register/register/register.component';

@Component({
  selector: 'app-root',
  standalone: true,
  //imports: [CommonModule, RouterOutlet, UsersComponent], // aqui importar el componente cuando se quiera usar el componente en el app principal
  imports: [
    // aqui importar el componente cuando se quiera usar el componente en el app principal
    CommonModule, 
    RouterOutlet
    //LoginComponent,
    //RegisterComponent
    ], 
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

logout() {
  throw new Error('Method not implemented.');
}
  
  authService = inject(AuthService)

  ngOnInit(): void {
    
  }
  title = 'VARIABLE DEL Front-Angular';
  saludo = 'Saludos desde angular';
}
