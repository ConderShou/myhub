import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

	gameCounter = 0;
	oddNums = [];
	evenNums = [];

	displayCounter(event: {counter: number}) {
			this.gameCounter = event.counter;

			if (event.counter % 2) {
				this.oddNums.push(event.counter);
			} else {
				this.evenNums.push(event.counter);
			}
	}
}
