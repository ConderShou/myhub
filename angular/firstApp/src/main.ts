import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

//Starts your app by passing in the "App Module"
//	References "app.module.ts"
platformBrowserDynamic().bootstrapModule(AppModule);
