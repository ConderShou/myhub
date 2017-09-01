import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot
 } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';

import { ServersService } from '../servers.service';

interface Server {
	id: number;
	name: string;
	status: string;
}

@Injectable()
export class ServerResolver implements Resolve<Server> {

	constructor(private serversService: ServersService) {}

	//Executed EVERY TIME the component renders, so no need to setup an Observable - would work anyways
	
	//Now it loads the returned information IN ADVANCE

	//This information is stored in 'server' object we defined in app-routing

	//This method is automatically called by Angular when the route is loaded
	resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Server> | Promise<Server> | Server {
			return this.serversService.getServer(+route.params['id'] );
	}
}