import { AsyncPipe } from '@angular/common';
import { Component } from '@angular/core';
import { ProfileService } from '../../../services/auth/profile/profile.service';
import { Observable, of } from 'rxjs';
import { ProfileResponse } from '../../../services/auth/profile/profileResponse';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [AsyncPipe],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {

  public profileResponse$: Observable<ProfileResponse> | undefined

  astring$: Observable<string> | undefined;

  constructor(private service: ProfileService){}

    ngOnInit(): void {
      this.astring$ = of("Hello Observable!!!")
      //this.profileResponse$ = this.service.getProgile();
      this.profileResponse$ = this.service.getProgile();
    }
  

}
