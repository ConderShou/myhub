import { Injectable, EventEmitter } from '@angular/core';

import { LoggingService } from './logging.service'; 


// In order to inject a service into something, that something must have metadata (like @Component)
// To resolve this (i.e. to use LoggingService), we use the @Injectable decorator
// NOTE: Use 'Injectable' for the service you want to inject INTO

// You do not need to inject it into LoggingService

//Reminder: We also remove the function from the other components.

@Injectable()

export class AccountsService {
	  accounts = [
    {
      name: 'Master Account',
      status: 'active'
    },
    {
      name: 'Testaccount',
      status: 'inactive'
    },
    {
      name: 'Hidden Account',
      status: 'unknown'
    }
  ];

  //Event for Cross-Component communication
  statusUpdated = new EventEmitter<string>(); 


  //Add the constructor here to inject it

  constructor(private loggingService: LoggingService) {}

  addAccount(name: string, status: string) {

  	//Creating and pushing an object with 'name' and 'status' properties 
  	
  	this.accounts.push({name: name, status: status});

    this.loggingService.logStatusChange(status);
  }

  updateStatus(id: number, status: string) {
  	this.accounts[id].status = status;
    this.loggingService.logStatusChange(status);
  }
}