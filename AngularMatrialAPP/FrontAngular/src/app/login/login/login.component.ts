import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { iLoginRequest } from '../../Interfaces/iLoginRequest';
import { LoginService } from '../../services/login/login.service';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule,MatButtonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  

  loginError:string="";
  private regexGlobal = /\b(\d{1,3}(?:\.\d{1,3}){2}-[\dkK])\b/gm;

  //private rutRegex: RegExp = /^(\d{1,3}(\.\d{3})*|\d{1,9})\-(\d|k|K)$/;// con guion

  private rutRegex: RegExp = /^(\d{1,3}(\.\d{3})*|\d{1,9})\-?(\d|k|K)$/;//omite guion

  loginForm = this.formBuilder.group(
    {
    username: [
      '',
      Validators.required
      //,Validators.pattern(this.rutRegex)
      ],
    password: [
      '',
      Validators.required
      ]
    }
  );

  constructor(private formBuilder: FormBuilder, private router:Router, private LoginService: LoginService) {}

  login(){
    if(this.loginForm.valid){
      //console.log("llamar servicio login");
      this.LoginService.login(this.loginForm.value as iLoginRequest).subscribe({
        next:(userData) =>{
          console.log(userData)
        },
        error: (errorData) =>{
          console.error(errorData)
          this.loginError=errorData;
        },
        complete: () => {
          console.info("Login Completo")
          this.router.navigateByUrl('');
          this.loginForm.reset;
        }

      });
      
    } else{

      this.loginForm.markAllAsTouched();
      alert("Error al ingresar datos, no tiene formato rut");
    }
  }


  get username() {
    return this.loginForm.controls.username;
  }
  
  get password() {
    return this.loginForm.controls.password;
  }
}
