import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs/subscription';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit, OnDestroy {
  user: {id: number, name: string};

  paramsSubscription: Subscription;

  //ActivatedRoute object will give us access to the 'id' passed in the URL
  // This will allow us to interact with the currently selected user
  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
  	this.user = {

  		//Getting the parameter 'id' we defined in the app.module
  		// And now, 'name'
  		//localhost:4200/1/Max - Displays User with ID 1 and name Max

  		//Snapshots only gather the information at the moment the component is rendered
  		id: this.route.snapshot.params['id'],
  		name: this.route.snapshot.params['name']
  	};

  	  // To be able to re-render the component based on new data, we use the 'params' Observable
  	  //Observables allow us to work with asynchronous tasks

  	 //Subscribe takes 3 functions are arguments
  	 // First Arg - 1. Executed when new data is sent through Observable (i.e. when 'params' change)
  	 
  	 //This approach is best practice for detecting change in route parameters
  	this.paramsSubscription = this.route.params
  		.subscribe(
 				(params: Params) => {
 					this.user.id = params['id'];
 					this.user.name = params['name'];
 				}
  			);
  }

  //NOTE: This is for comprehension purposes ONLY
  //This is what Angular ALREADY does for you (Observables are on the Heap)

  ngOnDestroy() {
  	this.paramsSubscription.unsubscribe();
  }


}
