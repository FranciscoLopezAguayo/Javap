import { Component } from '@angular/core';

@Component({
  selector: 'app-session-storage-demo',
  standalone: true,
  imports: [],
  templateUrl: './session-storage-demo.component.html',
  styleUrl: './session-storage-demo.component.css'
})
export class SessionStorageDemoComponent {

  dataSave(){
    sessionStorage.setItem('Name', 'Sanjeev');
    sessionStorage.setItem('Country', 'India');
    sessionStorage.setItem('Age', '22');
  }

  get(){
    return sessionStorage.getItem('name');
  }

  dataRemove(){
    sessionStorage.removeItem('Name');
  }

  deleteAll(){
    sessionStorage.clear();
  }

}
