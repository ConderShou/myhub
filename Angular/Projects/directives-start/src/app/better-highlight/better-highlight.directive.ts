import { 
	Directive, 
	Renderer2, 
	OnInit, 
	ElementRef,
  HostListener, 
  HostBinding, 
  Input 
} from '@angular/core';

@Directive({
  selector: '[appBetterHighlight]'
})
export class BetterHighlightDirective implements OnInit {

	//Custom Property Binding
	// Allowing us to set the colors that we use in these properties dynamically

	//NOTE: Angular figures out on its own if the property we're binding to is of the directive or of the component

	//BUG: Even though we dynamically set it to 'yellow' at first. The element is 'transparent' to begin before we hover and de-hover over it.

	//SOLUTION: Use ngOnInit and set backgroundColor to default color once more there

	@Input() defaultColor: string = 'transparent';
	//@Input() highlightColor: string = 'blue';

	//Setting a property to the directive selector
	// i.e. like [ngClass] = "something.."

	//Now we do [appBetterHighlight] = "" to change highlightColor
	
	@Input('appBetterHighlight') highlightColor: string = 'blue';


	// Host Binding
	//backgroundColor is a property we're defining

	// Inside HostingBinding() we define - to which property of the host element we want to bind to 
		// i.e. style 
		// i.e. style.backgroundColor 

	// Camel case is important here. 
	// We're accessing the DOM property, which doesn't know dashes.

	//We set this property equal to the 'backgroundColor' property that we define here

	//NOTE: We need to initialize it so that it doesnt throw an error before we first mouse over it

	// @HostBinding('style.backgroundColor') backgroundColor: string = 'transparent';


	//Custom Property Binding

	@HostBinding('style.backgroundColor') backgroundColor: string = this.defaultColor;

	//Now we can set things to 'backgroundColor' as if it were actually the 'style.backgroundColor' property

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }

  ngOnInit() {

  		//BUG: Even though we dynamically set it to 'yellow' at first. The element is 'transparent' to begin before we hover and de-hover over it.

	//SOLUTION: Use ngOnInit and set backgroundColor to default color once more there

		//ngOnInit triggers RIGHT before the template is displayed

  	this.backgroundColor = this.defaultColor;

  	// We use the renderer in the ngOnInit implementation to create the same attribute effect

  	// setStyle
  	// 1. We need to input an element inside 'setStyle()'
  	// 2. Input what kind of style you want to set
  	// 3 . The value for the style you're trying to set
  	// 4. Optional flags for stuff - look it up if you want to use them 

  	// this.renderer.setStyle(this.elRef.nativeElement, 'background-color', 'blue');

  	//This is a better approach because with 'service-workers', you may not have access to the DOM - it's not run in the browser

  	
  }

  //Triggered whenever the event specified in the () occurs
  // This event's name is specified as a string 

  //mouseenter is one of the events supported by the DOM element that this directive sits on

  //All the events available to you from Event Binding are also available here

  //Can receive event data as mouseover() argument

  //This is the same thing as passing a method within the quotation marks set to the (event) on the HTML element
  //		i.e. (mouseenter) = "mousover($event)"

  // Can also listen to custom events 

  // mouseenter is when mouse hovers over the element.
  //mouseleave is when the mouse leaves the element
  // element is blue when mouse hovers over it, transparent when the mouse doesn't

  @HostListener('mouseenter') mouseover(eventData: Event) {
		
  	// this.renderer.setStyle(this.elRef.nativeElement, 'background-color', 'blue');

  	//Host Binding

  	this.backgroundColor = this.highlightColor;
	}

	@HostListener('mouseleave') mouseleave(eventData: Event) {
		
  	//this.renderer.setStyle(this.elRef.nativeElement, 'background-color', 'transparent');
	
		this.backgroundColor = this.defaultColor;
	}


}
