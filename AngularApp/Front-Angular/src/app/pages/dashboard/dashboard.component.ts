import { Component, OnDestroy, OnInit } from '@angular/core';
import { LoginService } from '../../services/auth/login.service';
import { JWTResponse } from '../../services/auth/jwt';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit, OnDestroy{

  userdata?:JWTResponse;
  userLoginOn:boolean=false;

  mostrarToken:string | undefined;
  constructor(private loginService:LoginService){}

  ngOnDestroy(): void {
    this.loginService.currentUserData.unsubscribe();
    this.loginService.currentUserLoginOn.unsubscribe();
  }

  ngOnInit(): void {

    this.mostrarToken = "";

    this.loginService.currentUserLoginOn.subscribe(
      {
        next:(userLoginOn) =>{
          this.userLoginOn=userLoginOn;
        }
      }
    );

    this.loginService.currentUserData.subscribe(
      {
        next:(userdata) =>{
          this.userdata=userdata;
        }
      }
    )
  }

  get(){
    return sessionStorage.getItem('token');
  }


}
