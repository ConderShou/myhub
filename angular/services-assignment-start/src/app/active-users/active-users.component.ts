import { Component, EventEmitter } from '@angular/core';

import { UsersService } from '../users.service';

@Component({
  selector: 'app-active-users',
  templateUrl: './active-users.component.html',
  styleUrls: ['./active-users.component.css']
})
export class ActiveUsersComponent {
  users: string[];
  //@Output() userSetToInactive = new EventEmitter<number>();

  constructor(private usersService: UsersService) {}

  onSetToInactive(id: number) {
    this.usersService.setToInactive(id);
  }
}
