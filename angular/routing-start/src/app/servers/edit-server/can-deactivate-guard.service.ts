//Ensuring that the user is only allowed to leave the component if they have either saved the changes or have confirmed that they are okay with discarding the changes

import { Observable } from 'rxjs/Observable';
import { CanDeactivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

//Forces whatever component that connects to this to implement the 'canDeactivate' method 

export interface CanComponentDeactivate {

	canDeactivate: () => Observable<boolean> | Promise<boolean> | boolean;
}

//Wraps our interface
export class CanDeactivateGuard implements CanDeactivate<CanComponentDeactivate> {

	//Has to be of type CanComponentDeactivate -> Must have canDeactivate Method 

	canDeactivate(component: CanComponentDeactivate, 
		currentRoute: ActivatedRouteSnapshot,
		currentState: RouterStateSnapshot,
		nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

		//Now our ROUTER (inputted as a param into this method) can execute canDeactivate in our service for THIS COMPONENT (inputted as parm into method), and can relay on the fact that the component we're currently on HAS the canDeactivated method
		return component.canDeactivate()
	}
}