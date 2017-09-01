 import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',

  //NOTE: styleUrls is an array because we can reference MULITPLE	stylesheets 

  //styleUrls: ['./servers.component.css']

  //Now, this takes in an array of strings, where you define the style in these strings

  //Backticks are used here again.

  //styleUrls: ['./app.conponent.css']

  styles: [` 
  	h3 {
  		color: dodgerblue;
  	}

  `]

})
export class AppComponent {
}
