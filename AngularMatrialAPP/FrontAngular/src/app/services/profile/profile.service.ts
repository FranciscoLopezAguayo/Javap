import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { environments } from '../../../environments/environments';
import { AuthService } from '../auth.service';
import { Observable, catchError, map, tap, throwError } from 'rxjs';
import { ProfileResponse } from '../../Interfaces/ProfileRsponse';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  authService = inject(AuthService)
  constructor(private http: HttpClient) { }

  url:string = environments.baseUrl;
  


  getProfile():Observable<ProfileResponse>{
    

    //return this.http.get('http://localhost:8081/api/v1/auth/authenticate');
    //return this.http.get<JWTResponse>('http://localhost:8081/api/v1/auth/authenticate');
    return this.http.get<ProfileResponse>(
      //'http://localhost:8081/api/v1/auth/authenticate',
      environments.baseUrl+"/auth/profile"
    ).pipe(
        tap( (userData: ProfileResponse) => {

          console.log(userData);
          //sessionStorage.setItem("token", userData);
          //sessionStorage.setItem("token", userData.jwt);
          //this.authService.StringTokenSig.set(userData.jwt);

          //sessionStorage.setItem("JWTResponse", JSON.stringify(userData));
          //this.authService.JWTResponseSig.set(userData);
          
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
