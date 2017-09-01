import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

//Import Routes, RouterModule from @angular/router

//import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UsersComponent } from './users/users.component';
import { ServersComponent } from './servers/servers.component';
import { UserComponent } from './users/user/user.component';
import { EditServerComponent } from './servers/edit-server/edit-server.component';
import { ServerComponent } from './servers/server/server.component';
import { ServersService } from './servers/servers.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


// ROUTES HAVE BEEN MOVED TO 'APP-ROUTING.MODULE.TS'
import { AppRoutingModule } from './app-routing.module';

import { AuthService } from './auth.service';
import { AuthGuard } from './auth-guard.service';
import { ServerResolver } from './servers/server/server-resolver.service';
import { CanDeactivateGuard } from './servers/edit-server/can-deactivate-guard.service';
import { ErrorPageComponent } from './error-page/error-page.component';

// //Defining our routes - an array becaus we will have multiple routes
// //Each route is a Javascript object in the array

// //path 
// // - The part of the URL after the domain
// //
// // i.e. path: 'users' => localhost:4200/users
// // Don't add the '/' in the path string
// /*
//   An empty path signifies the homepage domain.

//   path: '' => localhost:4200

// */


// //component 
// // - Load this component on this url/page 
// // Up to you to make sure that this component will look like a page

// const appRoutes: Routes = [
//   { path: '', component: HomeComponent },
//   { path: 'users', component: UsersComponent, children: [
//       { path: ':id/:name', component: UserComponent },
//   ] },

//   // Dynamic Path Segment
//   //a path with user/[anything else] will load this component
//   // That [anything else] will be interpreted as the 'id'

//   //NOTE: 'router-outlet' directive in AppComponent is RESERVED for all the components at the TOP LEVEL
//   //  Child routes ARE NOT INCLUDED IN THIS
//   // They have to be loaded NESTED into the server routes - Using router-outlet within THEM

//    { path: 'servers', component: ServersComponent, children: [
//     { path: ':id', component: ServerComponent },
//     { path: ':id/edit', component: EditServerComponent }
//    ]},

//    { path: 'not-found', component: PageNotFoundComponent},

//    //Redirecting
//    //    redirectTo: '/not-found' ==> route redirects to 'localhost:4200/not-found'

//    //** 
//    //    All paths not recognized.
//    // IMPORTANT: Make sure this is the LAST route in the array, this code is evaluated TOP - BOTTOM, so routes you define after this will be considered as UNRECOGNIZED

//    { path: '**', redirectTo: '/not-found'}

// ];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UsersComponent,
    ServersComponent,
    UserComponent,
    EditServerComponent,
    ServerComponent,
    PageNotFoundComponent,
    ErrorPageComponent
  ],

  //Import the RouterModule to be able to use 'appRoutes'

  //.forRoot() registers our routes for the main application
  
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,

    //This will be done in app-routing.module
    //RouterModule.forRoot(appRoutes)

    //Imported
    AppRoutingModule
  ],

  providers: [ServersService, AuthService, AuthGuard, CanDeactivateGuard, ServerResolver],
  bootstrap: [AppComponent]
})
export class AppModule { }
