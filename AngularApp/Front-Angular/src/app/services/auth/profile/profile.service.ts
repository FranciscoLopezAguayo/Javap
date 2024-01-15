import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProfileResponse } from './profileResponse';

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
    const url = 'http://localhost:8081/api/v1/auth/profile';

    //const token = localStorage.getItem('token');
    const token = `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxOTQwMTQxOS04IiwiaWF0IjoxNzA1MjY3MDc2LCJleHAiOjE3MDUyNjg4NzYsInJvbGUiOiJBRE1JTklTVFJBVE9SIiwibmFtZSI6ImZyYW5jaXNjbyBsb3BleiIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJSRUFEX0FMTF9QUk9EVUNUUyJ9LHsiYXV0aG9yaXR5IjoiUkVBRF9PTkVfUFJPRFVDVCJ9LHsiYXV0aG9yaXR5IjoiQ1JFQVRFX09ORV9QUk9EVUNUIn0seyJhdXRob3JpdHkiOiJVUERBVEVfT05FX1BST0RVQ1QifSx7ImF1dGhvcml0eSI6IkRJU0FCTEVfT05FX1BST0RVQ1QifSx7ImF1dGhvcml0eSI6IlJFQURfQUxMX0NBVEVHT1JJRVMifSx7ImF1dGhvcml0eSI6IlJFQURfT05FX0NBVEVHT1JZIn0seyJhdXRob3JpdHkiOiJDUkVBVEVfT05FX0NBVEVHT1JZIn0seyJhdXRob3JpdHkiOiJVUERBVEVfT05FX0NBVEVHT1JZIn0seyJhdXRob3JpdHkiOiJESVNBQkxFX09ORV9DQVRFR09SWSJ9LHsiYXV0aG9yaXR5IjoiUkVBRF9NWV9QUk9GSUxFIn0seyJhdXRob3JpdHkiOiJST0xFX0FETUlOSVNUUkFUT1IifV19.7gjmCJpqEZmKM_g2lwQ7klPKxOhvTa5FjFOFOkJbHik`;

    return this.http.get<ProfileResponse>(
      url,
      {headers: {Authorization: `Bearer ${token}`}}
      );
  }

}
