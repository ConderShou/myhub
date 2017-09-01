import { Component, EventEmitter } from '@angular/core';

import { UsersService } from '../users.service';

@Component({
  selector: 'app-inactive-users',
  templateUrl: './inactive-users.component.html',
  styleUrls: ['./inactive-users.component.css'],
})
export class InactiveUsersComponent {
  users: string[];
  //@Output() userSetToActive = new EventEmitter<number>();

  constructor(private usersService: UsersService) {}

  onSetToActive(id: number) {
    this.usersService.setToActive(id);
  }
}
