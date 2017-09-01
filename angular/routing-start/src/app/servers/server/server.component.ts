import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params, Data } from '@angular/router';
import { ServersService } from '../servers.service';

@Component({
  selector: 'app-server',
  templateUrl: './server.component.html',
  styleUrls: ['./server.component.css']
})
export class ServerComponent implements OnInit {
  server: {id: number, name: string, status: string};

  constructor(private serversService: ServersService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

  	//Observable used because the data on the page CAN change while we are on it
  	this.route.data
  		.subscribe(
  			(data: Data) => {

  				//The property name here MUST MATCH the property you defined in app-routing
  				// 	i.e. { path: ':id', component: ServerComponent, resolve: {server: ServerResolver} },
  				
  				this.server = data['server'];
  			}
  		 );

  	//This will return the STRING of '1' not the number that we need to input into the 'getServers()' method

  	//The '+' sign will convert the string into a number
  	// const id = +this.route.snapshot.params['id'];


   //  this.server = this.serversService.getServer(id);

   //  this.route.params.subscribe(
   //  	(params: Params) => {
   //  		this.server = this.serversService.getServer(+params['id']);
   //  	});


  }

  onEdit() {

  	//Creating an absolute route
  	//this.router.navigate(['/servers', this.server.id, 'edit']);

  	//Creating a relative Route

  	//queryParamsHandling
  	//
  	// queryParamsHandling: 'merge' 
  	//
  	//		Merge old query params with any new ones you add


  	// queryParamsHandling: 'preserve'
  	//
  	//		Overriding the default behavior of dropping the query params, making sure that they are kept instead
  	//		i.e. 'allowEdit' and '#loading'
  	//
  	//If we were to add new Query Params, the old ones would override the new ones (b/c we're PRESERVING the old ones), so it would then be better to use 'merge' 

  	this.router.navigate(['edit'], {relativeTo: this.route, queryParamsHandling: 'preserve'});
  }

}
