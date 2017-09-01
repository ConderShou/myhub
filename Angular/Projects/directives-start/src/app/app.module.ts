import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

//Import directives

import { BasicHighlightDirective } from './basic-highlight/basic-highlight.directive';

//Adjust file path after moving it into a folder
import { BetterHighlightDirective } from './better-highlight/better-highlight.directive';
import { UnlessDirective } from './unless.directive';

@NgModule({

  //Add them in as a declaration
  
  declarations: [
    AppComponent,
    BasicHighlightDirective,
    BetterHighlightDirective,
    UnlessDirective
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
