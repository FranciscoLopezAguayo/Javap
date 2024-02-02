import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { iUserRegister } from '../../Interfaces/iUserRegister';
import { environments } from '../../../environments/environments.prod';
import { RegisterService } from '../../services/register/register.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  /*fb = inject(FormBuilder);
  http = inject(HttpClient);
  authService = inject(AuthService);
  router = inject(Router);


  form = this.fb.group(
    {
      email: ['', Validators.required],
      name: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required],
      repeatedPassword: ['', Validators.required],
    }
    
  );*/

/*
  onSubmit(): void {


  }*/
  constructor(private formBuilder: FormBuilder, private router:Router, private RegisterService: RegisterService) {}

  loginError:string="";
  private regexGlobal = /\b(\d{1,3}(?:\.\d{1,3}){2}-[\dkK])\b/gm;

  //private rutRegex: RegExp = /^(\d{1,3}(\.\d{3})*|\d{1,9})\-(\d|k|K)$/;// con guion

  private rutRegex: RegExp = /^(\d{1,3}(\.\d{3})*|\d{1,9})\-?(\d|k|K)$/;//omite guion

  Registerform = this.formBuilder.group(
    {
    email: [
      '',
      Validators.required
      //,Validators.pattern(this.rutRegex)
      ],
    name: [
      '',
      Validators.required
      ],
    username: [
      '',
      Validators.required
      ],
    password: [
      '',
      Validators.required
      ],
    repeatedPassword: [
      '',
      Validators.required
      ]
    }

  );

  Register(){
    if(this.Registerform.valid){
      //console.log("llamar servicio login");
      this.RegisterService.Register(this.Registerform.value as iUserRegister).subscribe({
        next:(userData) =>{
          console.log(userData)
        },
        error: (errorData) =>{
          console.error(errorData)
          this.loginError=errorData;
        },
        complete: () => {
          console.info("Registro Completo")
          this.router.navigateByUrl(''); // dashboard o menu principal
          this.Registerform.reset;
        }
      });
      
    } else{
      this.Registerform.markAllAsTouched();
      alert("Error al ingresar datos, no tiene formato rut");
    }
  }

/* email:string;
    name:string;
    username:string;
    password:string;
    repeatedPassword:string;
    role:string;
    jwt:string;
 */

  get email() {
    return this.Registerform.controls.username;
  }
  
  get name() {
    return this.Registerform.controls.password;
  }

  get username() {
    return this.Registerform.controls.username;
  }
  
  get password() {
    return this.Registerform.controls.password;
  }

  get repeatedPassword() {
    return this.Registerform.controls.username;
  }
  
  

}
