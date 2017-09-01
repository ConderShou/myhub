import { Component, EventEmitter, Output } from '@angular/core';

//Importing a service

import { LoggingService } from '../logging.service';
import { AccountsService } from '../accounts.service';

@Component({
  selector: 'app-new-account',
  templateUrl: './new-account.component.html',
  styleUrls: ['./new-account.component.css'],

  //sets up Angular so that it can provide the class 'LoggingService' when we require it in the class definition of this component

  //providers: [LoggingService]
})
export class NewAccountComponent {
  @Output() accountAdded = new EventEmitter<{name: string, status: string}>();

  //HOW TO ACTUALLY INSTANTIATE A SERVICE CLASS IN Angular
  //   1. Define it in the constructor (the method below is shorthand)
  //  
  //   2. You MUST set the type to the service class that you are trying to inject/import (LoggingService)
  //
  //   3. Include another property in the @Component decorator called 'providers' that takes in an Array. Specify the service that you are importing in it
  //
  //   4. Use it anywhere in the class as if you instantiated it like the other example from before (the wrong way)
  //      i.e. this.loggingService.logStatusChange(accountStatus)
  
  constructor(private loggingService: LoggingService,
    private accountsService: AccountsService) {

    //Cross-Component communication
    //Using subscribe to LISTEN for the event emitted
    this.accountsService.statusUpdated.subscribe(
      (status: string) => alert('New Status '+ status)
      );

  }

  onCreateAccount(accountName: string, accountStatus: string) {
    // this.accountAdded.emit({
    //   name: accountName,
    //   status: accountStatus
    // });

    this.accountsService.addAccount(accountName, accountStatus);

    //console.log('A server status changed, new status: ' + accountStatus);

    // This is NOT how you use the service in Angular.
    // DO NOT INSTANTIATE IT ON YOUR OWN

    // const service = new LoggingService();
    // service.logStatusChange(accountStatus); 

   // this.loggingService.logStatusChange(accountStatus);
  }
}
