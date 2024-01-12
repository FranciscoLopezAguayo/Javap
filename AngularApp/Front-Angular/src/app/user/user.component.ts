import { Component } from '@angular/core';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  username: string = '19401419-8';
  name: string = 'francisco';
  email: string = 'fjla@email.cl';
  role: string = 'ADMIN';

  numeroPublico: number = 99;

  private numero: number = 100;


  getNumeroPrivado():number{
    //asi se devuelve una variable privada
    return this.numero;
  }


}
