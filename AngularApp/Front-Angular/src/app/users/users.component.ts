import { Component } from '@angular/core';
import { UserComponent } from '../user/user.component';

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [UserComponent],
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {
  deshabilitar = false;
  mensaje: string = "no se ha agregado nadie";
  titulo = '';

  ADD_User(){
    this.mensaje="persona agregada";
  }

  modificartitulo(event: Event){
    //este evento se puede ejecutar cada vez que se actualiza algo
  this.titulo = (<HTMLInputElement>event.target).value

  }

}
