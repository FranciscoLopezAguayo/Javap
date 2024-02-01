import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { ProfileResponse } from '../auth/profile/profileResponse';
import { environments } from '../../../environments/environments';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  getUser(id:string):Observable<ProfileResponse>{

    const token = environments.token1ANNIO;

    return this.http.get<ProfileResponse>(
      environments.baseAPI+'/auth/authenticate',
      {headers: {Authorization: `Bearer ${token}`}}
      ).pipe(
        catchError(this.handleError)
      )
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
