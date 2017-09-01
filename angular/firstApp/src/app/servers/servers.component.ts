import { Component, OnInit } from '@angular/core';

@Component({

  //For the record, we usually use the normal element selector format for components - we'll learn about directives later that might change this


  //Can put the selector tag in [] to select the ATTRIBUTES
  // Attributes are the keywords you type within the tag of an HTML element - i.e <div app-servers></div>

  //selector: '[app-servers]',


  //Can also select by CLASS

  selector: 'app-servers',

  //CANNOT select by ID or pseudoselectors (hover, etc..) - not supported by Angular


  //One of the two have to be present AT ALL TIMES, either:
  // a. 'templateUrl' to an external template
  // b. 'template' to define our HTML in this same file (inline)
  // Don't have to use styles, but templates HAVE to exist

  //NOTE: You cannot wrap this line with normal quotation marks/apostraphes, becaue HTML is not supported automatically. It has to be contained within this as a string.
  //BUT you CAN wrap it when you use the BACKTICK - javascript template expressions - you can then write multiple lines now
 
  //Using more than three lines in HTML code probably suggests that you should use an external HTML file instead

  //NOTE: In this case, you don't need the selector anymore - (wait what is this, this note makes no sense right here)

  //We'll also learn more about omitting selectors with routing stuff later on


  templateUrl: "./servers.component.html",

  styleUrls: ['./servers.component.css']
})

export class ServersComponent implements OnInit {

  allowNewServer = false;

  serverCreationStatus = 'No server was created!';
  serverName = '';
  serverCreated = false; 
  servers = ['Testserver', 'Testserver 2']
  //This method is executed at the moment this component is created by Angular   
  constructor() {
    
    //After 2 seconds, (2000 milliseconds), the variable will be set to true
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000);

   }

  ngOnInit() {
  }


  onCreateServer() {
    this.serverCreated = true;
    this.servers.push(this.serverName); 
    this.serverCreationStatus = 'Server was created! Name is ' + this.serverName;  
  }

  //Receiving the $event data from the html

  onUpdateServerName(event: Event) {

    //Note, we have to explicitly cast the value to Input element because 'value' is not available to ALL EVENT TARGETS (the type that we have 'event' defined as in the param)
    //Casting generics, basically

    this.serverName = (<HTMLInputElement>event.target).value;

  }
}
