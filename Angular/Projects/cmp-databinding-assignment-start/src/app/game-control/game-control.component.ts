import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-game-control',
  templateUrl: './game-control.component.html',
  styleUrls: ['./game-control.component.css']
})
export class GameControlComponent implements OnInit {


	counter = 0;
	ref = null;

	@Output() counterCreated = new EventEmitter<{counter: number}>();

  constructor() { }

  ngOnInit() {
  }

  startCounter() {
  	
  	this.ref = setInterval(() => {

  		this.counterCreated.emit({
  			counter: ++this.counter
  		})
  	}, 1000);
  }

  stopCounter() {
  	
  	clearInterval(this.ref);

  }
 	
 	gameEmitter() {

 		this.counter++;

 			this.counterCreated.emit({
				counter: this.counter
			});

 	}


 

}
