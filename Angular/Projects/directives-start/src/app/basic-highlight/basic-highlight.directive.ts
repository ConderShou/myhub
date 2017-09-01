import { Directive, ElementRef, OnInit } from '@angular/core';

@Directive({

	//Selectors work the same way as they do in components
	//		Rules for making the selectors work as attributes VS element VS classes remain the same
	// Use camelCase instead of dashes -

	// We want this particular directive to be an attribute

	selector: '[appHighlight]'

	//We cannot add a template to a directive
})

//Directives have OnInit and OnDestroy but not the rest of the lifecycle hooks

export class BasicHighlightDirective implements OnInit{

	//Automatically creates a private 'elementRef' variable upon instantiation of this directive

	// Bounds the argument to this private property

	// Due to injection (? - explained later ?) Angular will provide the ElementRef of the element that this directive is PLACED ON

	constructor(private elementRef: ElementRef) {
	}

	/* REMEMEBER:

	2. ngOnInit    - Called once component is initialized

      This is BEFORE it has been added to the DOM.

      The properties can now be accessed and initialized.
    
      !! - Run after the CONSTRUCTOR. - !!

    */

	ngOnInit() {

		// This works as our preliminarty approach for understanding directives, BUT:
		//	Not recommended in pretty much any case

		this.elementRef.nativeElement.style.backgroundColor = 'green';

		//Angular can render things without a DOM, so when you use 'elementRef', in advanced use cases errors can occur.

	}
}