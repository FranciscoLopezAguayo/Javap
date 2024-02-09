import { Injectable, inject } from '@angular/core';
import { environments } from '../../../environments/environments';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { iUserRegister } from '../../Interfaces/iUserRegister';
import { Observable, catchError, map, tap, throwError } from 'rxjs';
import { AuthService } from '../auth.service';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  authService = inject(AuthService)
  constructor(private http: HttpClient) { }

  url:string = environments.baseUrl;

  Register(RegisterUser:iUserRegister):Observable<iUserRegister>{
    console.log(RegisterUser);

    //return this.http.get('http://localhost:8081/api/v1/auth/authenticate');
    //return this.http.get<JWTResponse>('http://localhost:8081/api/v1/auth/authenticate');
    return this.http.post<iUserRegister>(
      environments.baseUrl+"/customers",
      RegisterUser
    ).pipe(
        tap( (userData: iUserRegister) => {
          //sessionStorage.setItem("token", userData)
          sessionStorage.setItem("token", userData.jwt)
          this.authService.StringTokenSig.set(userData.jwt)
          
          //sessionStorage.setItem("iUserRegister", JSON.stringify(userData))
          sessionStorage.setItem("iUserRegister", JSON.stringify(userData))
          this.authService.CurrentUserSig.set(userData);
        }),
        map((userData) => userData),
      catchError(this.handleError)
    );
  }

  private handleError(error:HttpErrorResponse){
    if(error.status===0){
      console.error('Se ha producido un error',error.error);
    }else{
      console.error('Backend rerorno status code',error.status, error.error);
    }
    return throwError(()=> new Error('Ago fallo, intenta nuevamente'));

  }

}
