import { NgModule } from '@angular/core';

import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UsersComponent } from './users/users.component';
import { ServersComponent } from './servers/servers.component';
import { UserComponent } from './users/user/user.component';
import { EditServerComponent } from './servers/edit-server/edit-server.component';
import { ServerComponent } from './servers/server/server.component';
import { ServersService } from './servers/servers.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { AuthGuard } from './auth-guard.service';
import { CanDeactivateGuard } from './servers/edit-server/can-deactivate-guard.service';

import { ServerResolver } from './servers/server/server-resolver.service';
//Defining our routes - an array becaus we will have multiple routes
//Each route is a Javascript object in the array

//path 
// - The part of the URL after the domain
//
// i.e. path: 'users' => localhost:4200/users
// Don't add the '/' in the path string
/*
  An empty path signifies the homepage domain.

  path: '' => localhost:4200

*/


//component 
// - Load this component on this url/page 
// Up to you to make sure that this component will look like a page

const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'users', component: UsersComponent, children: [
      { path: ':id/:name', component: UserComponent },
  ] },

  // Dynamic Path Segment
  //a path with user/[anything else] will load this component
  // That [anything else] will be interpreted as the 'id'

  //NOTE: 'router-outlet' directive in AppComponent is RESERVED for all the components at the TOP LEVEL
  //  Child routes ARE NOT INCLUDED IN THIS
  // They have to be loaded NESTED into the server routes - Using router-outlet within THEM

   { 
   	path: 'servers', 
   	//canActivate: [AuthGuard], 

   	//Now ONLY the child routes are protected
   	canActivateChild: [AuthGuard],
   	component: ServersComponent, 
   	children: [

   	//'server' in the resolve - now contains the returned data from ServerResolver
   	//The 'resolve' method is automatically called in 'ServerResolver' when this route is loaded and stored in the 'server' object/property of the Component to be loaded

   	//This data is sent as the 'Data' object we saw with the static data below
    { path: ':id', component: ServerComponent, resolve: {server: ServerResolver} },
    { path: ':id/edit', component: EditServerComponent, canDeactivate: [CanDeactivateGuard] }
   ]},
   
   // { path: 'not-found', component: PageNotFoundComponent},
   { path: 'not-found', component: ErrorPageComponent, data: {message: 'Page not found!'} },

   //Redirecting
   //    redirectTo: '/not-found' ==> route redirects to 'localhost:4200/not-found'

   //** 
   //    All paths not recognized.
   // IMPORTANT: Make sure this is the LAST route in the array, this code is evaluated TOP - BOTTOM, so routes you define after this will be considered as UNRECOGNIZED

   { path: '**', redirectTo: '/not-found'}

];

@NgModule ({
	//No need to redeclare the components (already done in AppModule)

	imports: [

    //Setting the hash to True tells the webserver to ONLY worry about the part of the URL before the hash (the hash is placed right after the root path element)

    //  The part of the URL AFTER the hash is then parsed by Angular itself 

    //Only use this if you have to - otherwise use the prettier version of the URL

		// RouterModule.forRoot(appRoutes, {useHash: true})
    RouterModule.forRoot(appRoutes)
	],

	//IMPORTANT:

	//Exporting the NOW CONFIGURED RouterModule
	exports: [RouterModule]
})

export class AppRoutingModule {


}