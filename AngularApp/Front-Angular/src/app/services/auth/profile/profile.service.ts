import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProfileResponse } from './profileResponse';
import { environments } from '../../../../environments/environments';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) { }

/*
const url = '/userinfo';
const header = new HttpHeaders().set('Authorization', this.tokenType + this.cookieService.get('token')); // may be localStorage/sessionStorage
const headers = { headers: header };
return this.httpClient.get(this.serverUrl + url,headers);

*/
  getProgile(): Observable<ProfileResponse>{
    //const url = 'http://localhost:8081/api/v1/auth/profile';

    //const token = localStorage.getItem('token');
    const token = environments.token1ANNIO;

    return this.http.get<ProfileResponse>(
      environments.baseAPI+"/auth/profile",
      {headers: {Authorization: `Bearer ${token}`}}
      );
  }

}
