/* 1. Connect custom component to app.module (can also connect to other components that we want as a parent instead?)
	- Import
	- @NgModule
2. Make the html selector in the app.component.html (and would this also work for another component besides app.component? Presumably so, right?)
*/

//We can use component selectors in any other template in any other component

//Imports the Component decorator
import { Component } from '@angular/core';

//Tells Angular this is not just a normal Typescript class, but a Component
//	So we add a DECORATOR (used to enhance elements of the code - not just for classes)
//	Also passing a Javascript object to this decorator to configure it
@Component({
	//We can set up information to be stored as metadata for this class in the background 
	//  that will tell Angular what to do with this class
 	
	//Selects the HTML tag that you can use this component with in the other components' template
 	//    Prefix it with "app-" and then set it as any UNIQUE string
 	selector: 'app-server', 

 	//Telling Angular where to find the HTML template 
 	templateUrl: './server.component.html',

 	styles: [`
		   .online {
		   		color: white;
		   }
 	`]

})

//Exporting this class to AppComponent for it to use
export class ServerComponent {

	//Don't have to explicitly state the types, but it's optional 
	// TypeScript feature
	serverID: number = 10;
	serverStatus: string = 'offline';

	constructor() {

		this.serverStatus = Math.random() > 0.5 ? 'online' : 'offline';
	}
	//Defining a server in TypeScript
	getServerStatus() {
			return this.serverStatus;
	}

	getColor() {
		return this.serverStatus === 'online' ? 'green' : 'red';
	}
 

}

