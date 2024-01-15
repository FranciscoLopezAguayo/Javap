import { AsyncPipe } from '@angular/common';
import { Component } from '@angular/core';
import { ProfileService } from '../../../services/auth/profile/profile.service';
import { Observable } from 'rxjs';
import { ProfileResponse } from '../../../services/auth/profile/profileResponse';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [AsyncPipe],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {

  public profileResponse$!: Observable<ProfileResponse>

  constructor(private service: ProfileService){}

    ngOnInit(): void {
      this.profileResponse$ = this.service.getProgile();
    }
  

}
