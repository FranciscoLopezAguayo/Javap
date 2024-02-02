import { Injectable, signal } from '@angular/core';
import { iUserRegister } from '../Interfaces/iUserRegister';
import { JWTResponse } from '../Interfaces/JWTResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  CurrentUserSig = signal<iUserRegister | undefined | null>(undefined);
  TokenSig = signal<JWTResponse | undefined | null>(undefined);
  StringTokenSig = signal<String | undefined | null>(undefined);

  JWTResponseSig = signal<JWTResponse | undefined | null>(undefined);


  constructor() { }
}
