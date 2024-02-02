import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  //imports: [CommonModule, RouterOutlet, UsersComponent], // aqui importar el componente cuando se quiera usar el componente en el app principal
  imports: [
    // aqui importar el componente cuando se quiera usar el componente en el app principal
    CommonModule, 
    RouterOutlet
    ], 
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'VARIABLE DEL Front-Angular';
  saludo = 'Saludos desde angular';
}
