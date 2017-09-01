import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  //Manually feeding a javascript object into the array with these properties
  serverElements = [{type: 'server', name: 'Testserver', content: 'Just a test!'}];
  
  //These functions are triggered AFTER the buttons have been clicked

   onServerAdded(serverData: {serverName: string, serverContent: string}) {
    this.serverElements.push({
      type: 'server',
      name: serverData.serverName,
      content: serverData.serverContent
    });
  }

  onBlueprintAdded(bpData: {serverName: string, serverContent: string}) {
    this.serverElements.push({
      type: 'blueprint',
      name: bpData.serverName,
      content: bpData.serverContent
    });
  }

  
}
