import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';
import { AuthService } from './services/auth.service';
import { LoginService } from './services/login/login.service';

import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import { ProfileService } from './services/profile/profile.service';
import { Observable } from 'rxjs';
import { ProfileResponse } from './Interfaces/ProfileRsponse';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, 
    
    MatButtonModule, 
    MatDividerModule, 
    MatIconModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'FrontAngular';


  constructor(private router:Router, private loginService: LoginService, private profileService: ProfileService) {}



  logout() {

    console.log("Method not implemented RE Enrutar");
    this.loginService.logout();
    this.router.navigateByUrl('');
  }


 
    
    authService = inject(AuthService)
  
    ngOnInit(): void {
      
    }
    //title = 'VARIABLE DEL Front-Angular';
    saludo = 'Saludos desde angular';

    public profileResponse: Observable<ProfileResponse> | undefined | null;


    
    test() {

      console.log("GET PROFILE");
      console.log(this.profileService.getProfile());
      this.profileResponse = this.profileService.getProfile();
    }
}
