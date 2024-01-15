import { Injectable } from '@angular/core';
import { LoginRequest } from './loginRequest';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError, BehaviorSubject, tap} from 'rxjs';
import { JWTResponse } from './jwt';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  currentUserLoginOn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  currentUserData: BehaviorSubject<JWTResponse> = new BehaviorSubject<JWTResponse>({jwt:"TOKEN AQUI"});

  constructor(private http: HttpClient) { }

  login(credentials:LoginRequest):Observable<JWTResponse>{
    console.log(credentials);

    //return this.http.get('http://localhost:8081/api/v1/auth/authenticate');
    //return this.http.get<JWTResponse>('http://localhost:8081/api/v1/auth/authenticate');
    return this.http.post<JWTResponse>(
      'http://localhost:8081/api/v1/auth/authenticate',
      credentials
    ).pipe(
        tap( (userData: JWTResponse) => {
          this.currentUserData.next(userData);
          this.currentUserLoginOn.next(true);
        })
      ,catchError(this.handleError)
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

  get userData():Observable<JWTResponse>{
    return this.currentUserData.asObservable();
  }

  get userLoginOn(): Observable<boolean>{
    return this.currentUserLoginOn.asObservable();
  }

}
