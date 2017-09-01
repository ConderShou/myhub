import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ServerComponent } from './server/server.component';

//CLI automatically connected the new component to the app module

import { ServersComponent } from './servers/servers.component'; 

//.ts extension is added by Webpack AUTOMATICALLY

@NgModule({
  declarations: [
    AppComponent,
    ServerComponent,
    ServersComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],

  //Lists ALL the components that should be known to Angular at the point of time it analyzes the HTML files
  bootstrap: [AppComponent]
})
export class AppModule { }
