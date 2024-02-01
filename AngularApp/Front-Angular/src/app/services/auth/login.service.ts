import { Injectable } from '@angular/core';
import { LoginRequest } from './loginRequest';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError, BehaviorSubject, tap, map} from 'rxjs';
import { JWTResponse } from './jwt';
import { environments } from '../../../environments/environments';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  url:string = environments.baseUrl;

  currentUserLoginOn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  currentUserData: BehaviorSubject<JWTResponse> = new BehaviorSubject<JWTResponse>({"jwt":"NO HAY JWT"});

  constructor(private http: HttpClient) { 
    //this.currentUserLoginOn = new BehaviorSubject<boolean>(sessionStorage.getItem("token")!= null);
    //this.currentUserData = new BehaviorSubject<JWTResponse>(sessionStorage.getItem("token") || "");
    //this.currentUserData = new BehaviorSubject<JWTResponse>(JSON.parse(sessionStorage.getItem("token") || ""));

  }

  login(credentials:LoginRequest):Observable<JWTResponse>{
    console.log(credentials);

    //return this.http.get('http://localhost:8081/api/v1/auth/authenticate');
    //return this.http.get<JWTResponse>('http://localhost:8081/api/v1/auth/authenticate');
    return this.http.post<JWTResponse>(
      //'http://localhost:8081/api/v1/auth/authenticate',
      environments.baseUrl+"/auth/authenticate",
      credentials
    ).pipe(
        tap( (userData: JWTResponse) => {
          //sessionStorage.setItem("token", userData)
          sessionStorage.setItem("token", JSON.stringify(userData))
          
          this.currentUserData.next(userData);
          this.currentUserLoginOn.next(true);
        }),
        map((userData) => userData),
      catchError(this.handleError)
    );
  }

  logout():void{
    //sessionStorage.removeItem("token");
    this.currentUserLoginOn.next(false);
  }

  private handleError(error:HttpErrorResponse){
    if(error.status===0){
      console.error('Se ha producido un error',error.error);
    }else{
      console.error('Backend rerorno status code',error.status, error.error);
    }
    return throwError(()=> new Error('Ago fallo, intenta nuevamente'));

  }

  get userData():Observable<JWTResponse>{
    return this.currentUserData.asObservable();
  }
  /*
  get userData():Observable<string>{
    return this.currentUserData.asObservable();
  }*/

  get userLoginOn(): Observable<boolean>{
    return this.currentUserLoginOn.asObservable();
  }

}
