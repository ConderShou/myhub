import { Component, Input} from '@angular/core';

import { LoggingService } from '../logging.service';

//IMPORTANT: By importing this AGAIN here when we already did in AppComponent, we are giving this component a NEW INSTNCE OF ACCOUNTSSERVICE. 
//    One that is SEPARATE from the one in AppComponent.
//  Therefore, when we update the status of the account here, it does not change the one being displayed by AppComponent
//  i.e. AppComponent is rendering another 'accounts' array from a different instance of AccountsService

//Solution: Resolve this issue by just removing the service from the provider's array

import { AccountsService } from '../accounts.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css'],
  
  //To use the same service instance as AppComponent, don't include the service in the provider array.
  // Keep everything else.

  // providers: [LoggingService, AccountsService]

  //providers: [LoggingService]
})

export class AccountComponent {
  @Input() account: {name: string, status: string};
  @Input() id: number;
  // @Output() statusChanged = new EventEmitter<{id: number, newStatus: string}>();

  constructor(private loggingService: LoggingService,
              private accountsService: AccountsService) {

  }

  onSetTo(status: string) {
    //this.statusChanged.emit({id: this.id, newStatus: status});
    

    this.accountsService.updateStatus(this.id, status);

    //Cross-Component Communication
    //Emitting a status via service to communicate with an adjacent component

    this.accountsService.statusUpdated.emit(status);

    //this.loggingService.logStatusChange(status);
  }
}
