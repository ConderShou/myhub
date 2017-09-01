import { 
	CanActivate, 
	ActivatedRouteSnapshot, 
	Router, 
	RouterStateSnapshot, 
	CanActivateChild
} from '@angular/router';

import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';

@Injectable()

export class AuthGuard implements CanActivate, CanActivateChild {


	constructor(private authService: AuthService, private router: Router) {}


	//This can run ASYNC (Observable + Promise) and SYNC (boolean)

	//Auth Guard will prevent the user from accessing the route unless its canActivate function returns True

	//In AppModule, if AuthGuard returns true => the servers route (where it has been placed) will allow the user to access it
	// Else, the user will be REDIRECTED HOME

	canActivate(route: ActivatedRouteSnapshot,
		state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

			return this.authService.isAuthenticated()
				.then(
						(authenticated: boolean) => {
							if (authenticated) {
								return true;
							} else {

								//Redirected to Homepage after 800 ms if user is not logged in (800 ms from AuthService)
								this.router.navigate(['/']);

								//Optional
								//return false;
							}
						}
					);
	}

//If used in route array in 'canActivateChild', then ONLY the child routes are protected
	canActivateChild(route: ActivatedRouteSnapshot, 
									state: RouterStateSnapshot): Observable<boolean> | Promise <boolean> | boolean {
		return this.canActivate(route, state);
	}
}