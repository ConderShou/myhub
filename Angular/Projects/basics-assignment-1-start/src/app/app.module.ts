import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { WarningAlertComponent } from './WarningAlert/warningalert.component';
import { SuccessAlertComponent } from './SuccessAlert/successalert.component';
import { AlertsComponent } from './alerts/alerts.component';

@NgModule({
  declarations: [
    AppComponent,
    WarningAlertComponent,
    SuccessAlertComponent,
    AlertsComponent
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
