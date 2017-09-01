import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

//FormsModule is for the Template-Driven approach
//import { FormsModule } from '@angular/forms';

//Reactive Forms module
import { ReactiveFormsModule } from '@angular/forms';

import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    //FormsModule,
    HttpModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
