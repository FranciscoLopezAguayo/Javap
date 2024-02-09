import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { environments } from '../../../environments/environments';

import { Observable, catchError, map, tap, throwError } from 'rxjs';
import { JWTResponse } from '../../Interfaces/JWTResponse';
import { iLoginRequest } from '../../Interfaces/iLoginRequest';
import { AuthService } from '../auth.service';



@Injectable({
  providedIn: 'root'
})

export class LoginService {
  authService = inject(AuthService)
  constructor(private http: HttpClient) { }

  url:string = environments.baseUrl;

  login(credentials:iLoginRequest):Observable<JWTResponse>{
    console.log(credentials);

    //return this.http.get('http://localhost:8081/api/v1/auth/authenticate');
    //return this.http.get<JWTResponse>('http://localhost:8081/api/v1/auth/authenticate');
    return this.http.post<JWTResponse>(
      //'http://localhost:8081/api/v1/auth/authenticate',
      environments.baseUrl+"/auth/authenticate",
      credentials
    ).pipe(
        tap( (userData: JWTResponse) => {
          //sessionStorage.setItem("token", userData);
          sessionStorage.setItem("token", userData.jwt);
          this.authService.StringTokenSig.set(userData.jwt);

          sessionStorage.setItem("JWTResponse", JSON.stringify(userData));
          this.authService.JWTResponseSig.set(userData);
          
        }),
        map((userData) => userData),
      catchError(this.handleError)
    );
  }

  logout():void{

    localStorage.removeItem('token');
    localStorage.removeItem('JWTResponse');
    this.authService.StringTokenSig.set(null);
    this.authService.JWTResponseSig.set(null);
    this.authService.TokenSig.set(null);
    this.authService.CurrentUserSig.set(null);
    //sessionStorage.removeItem("token");
    //this.currentUserLoginOn.next(false);
  }

  private handleError(error:HttpErrorResponse){
    if(error.status===0){
      console.error('Se ha producido un error',error.error);
    }else{
      console.error('Backend rerorno status code',error.status, error.error);
    }
    return throwError(()=> new Error('Ago fallo, intenta nuevamente'));

  }
/*
  get userData():Observable<JWTResponse>{
    return this.currentUserData.asObservable();
  }*/
  /*
  get userData():Observable<string>{
    return this.currentUserData.asObservable();
  }*/
/*
  get userLoginOn(): Observable<boolean>{
    return this.currentUserLoginOn.asObservable();
  }*/
}
