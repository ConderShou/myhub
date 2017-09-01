import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styles: [`
		.fifth {
			color: white;
		}

  `]
})
export class AppComponent {

	toggleParagraph = true;
	clicks = [];
	clickNum = 0;
	afterFifth = false;

	constructor() {

		if (this.clicks[this.clickNum] >= 5)
				this.afterFifth = true;
	}

	toggleP() {

		if (this.toggleParagraph) 
			this.toggleParagraph = false;
		else 
			this.toggleParagraph = true;
			
		// this.clicks.push(++this.clickNum);

		this.clicks.push(new Date());
	}

	colorFifth(i) {

		return i >= 5 ? 'blue' : 'white';

	}
}
