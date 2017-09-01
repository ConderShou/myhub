import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  genders = ['male', 'female'];
  signupForm: FormGroup;

  ngOnInit() {

  	// Initialize form before the template is displayed

  	this.signupForm = new FormGroup({


  		//----Form Control---

  		//Contains CONTROLS - key:value pairs that we pass to the overall Form Group

  		//Wrapping in quotation marks so that during MINIFICATION, this property name is ensured to be kept
  		// Might not be necessary, might not get destroyed. 
  		// But we're just making sure.


  		//--Adding Controls
  		// Right now we are referencing the input fields that are existent in the HTML (username, email, radio)
  		
  		//Arguments to FormControl constructor:
  		// 1. Initial state/value
  		// 2. Single or array of validators
  		// 3. Async validators

  		'username': new FormControl(null);

  	});	
  }

}
