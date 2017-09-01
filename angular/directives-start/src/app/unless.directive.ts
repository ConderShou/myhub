import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({

  selector: '[appUnless]'
})
export class UnlessDirective {

	//Need to get condition as input, so we need a custom property 

	// 'set' 	
	// 
	/* This is STILL a property.
		'set' means that the method we specify in {} is executed WHENEVER THE PROPERTY CHANGES

		This is of course comes from whatever condition we specify in the HTML of the component

		IMPORTANT!!: We are binding to this property, so if we want to do '*appUnless', then this property needs to be named 'appUnless'

	*/
	@Input() set appUnless(condition: boolean) {

		if (!condition) {
 
			//createEmbeddedView = creates a view in this view container

			this.vcRef.createEmbeddedView(this.templateRef);

		} else {

			this.vcRef.clear();

		}

	}

	//REMEMBER: Angular transforms the * into a <ng-template [someProperty] = ""> 

	//TemplateRef refers to the <ng-template>, also a generic type so you can pass in 'any'

	// 1. What we render (template)
	// 2. Where we render it (ViewContainerRef) 

  constructor(private templateRef: TemplateRef<any>, private vcRef: ViewContainerRef) { }

}
