//Must import lifecycle hooks

import { 
	Component, 
	OnInit, 
	Input, 
	ViewEncapsulation,
	OnChanges,
	SimpleChanges,
	ContentChild,
	ElementRef
} from '@angular/core';

@Component({
  selector: 'app-server-element',
  templateUrl: './server-element.component.html',
  styleUrls: ['./server-element.component.css'],

  // Setting ViewEncapsulation to 'None' removes this default behavior of View Encapsulation.
  // Now, any CSS in this file will be applied GLOBALLY.

  // AGAIN - This means that any defined CSS styles in here, will ALSO be applied to corresponding HTML elements in OTHER COMPONENTS

  //The CSS selectors DO NOT get an additional attribute from Angular in this component.
  // And the HTML elements DO NOT get an additional attribute added in this component

  // This becomes a "super-style" component (This name is for me to remember to help remember this) 

  // encapsulation: ViewEncapsulation.None



  //This enables the Shadow DOM - meaning, the deafult View Encapsulation behavior will only be in effect in browsers that support a certain type of DOM behavior - nothing should change from default if the browser supports Shadow DOM. 
  // But it will be global in b rowsers that do not support Shadow DOM

  // encapsulation: ViewEncapsulation.Native

  // This is the default behavior. 
  //	No need to define it, it automatically is. 

  //encapsulation: ViewEncapsulation.Emulated
})

// Lifecycle hooks in action
//  Don't need to (can just define the function), but should implement lifecycle hook

export class ServerElementComponent implements OnInit {

	//A type with {} is a Javascript object 
	// @Input() is a decorator that allows 'element' to be accessed by other components

	// srvElement is an alias for 'element'. 
	//
	// Outside files refer to 'element' by referring to a property named 'srvElement'
	//
	// NOTE: referring to the element property by 'element' will NO LONGER work


	@Input('srvElement') element: {type: string, name: string, content: string};

	// Content Child
	// 		We access the content IN BETWEEN THE TAGS of this component's HTML tag selector in the app.component.html
	//		This means it accesses the <p> stuff in the app.component.html

	//We can use this like any other ElementRef element. Referencing nativeElement to get to the HTML element and using its properties thereafter

	@ContentChild('contentParagraph') paragraph: ElementRef;

  constructor() { }

  //The only hook that receives an input
  // SimpleChange reflects the change being made - speciies what variable/property
  // Initialization -> There's a SimpleChanges object for 'element'

  // ngOnChanges(changes: SimpleChanges) {

  // 	console.log('ngOnChanges called');
  // }

  ngOnInit() {
  }

}
