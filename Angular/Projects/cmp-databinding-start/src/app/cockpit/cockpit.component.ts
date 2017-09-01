//import EventEmitter for custom events
//import Output to output the events

import { Component, OnInit, EventEmitter, Output, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrls: ['./cockpit.component.css']
})
export class CockpitComponent implements OnInit {

  // Import EventEmitter to begin creating a custom event
  // 
  // Define in {} in between <>, the content of the event that you are planning to emit
  //
  // Put () at the end to call the CONSTRUCTOR of the EventEmitter, to create a new EventEmitter object and STORE it in 'serverCreated'

  //NOTE: Now we have the Output() decorator to make sure this informatino is 'listenable'


  //NOTE: Alias for Custom Event binding works like the Alias for Custom Properties
  // Now you can only listen to serverCreated through 'srvCreated'

  @Output('srvCreated') serverCreated = new EventEmitter<{serverName: string, serverContent: string}>();

  @Output() bpCreated = new EventEmitter<{serverName: string, serverContent: string}>();

	// newServerName = '';
  // newServerContent = '';
  
  // ViewChild
  //  1. Import ViewChild angular/core
  //  2. The argument of the ViewChild() decorator references the local reference we defined in the HTML
  //  3. The element being referenced is stored in 'srvContentInput'
  //
  // NOTE: ViewChild returns a type of 'ElementRef' NOT the literal HTML element like Local Reference does
  //    4. Import ElementRef to define this type

  @ViewChild('serverContentInput') srvContentInput: ElementRef;

  constructor() { }


/* Lifecycle Hooks
// 
// When Angular instantiates a new component, it goes through a series of phases.
//
// We have the opportunity to hook into these phases and execute some code
//
// 1. ngOnChanges   - Start & Called after a bound/custom input property changes (@Input() properties)
    
      Can be executed multiple times.

      - Excecuted at start upon its creation
      - And called after bound input property changes (@Input() properties), whenever the custom properties receive new values


   2. ngOnInit    - Called once component is initialized

      This is BEFORE it has been added to the DOM.

      The properties can now be accessed and initialized.
    
      !! - Run after the CONSTRUCTOR. - !!


   3. ngDoCheck    - Called during every change detection run

       Will be executed A LOT - 
           This is called whenever something has changed inside the component, and Angular must see if it has to change something inside the TEMPLATE

        THIS INCLUDES CLICKING/ACTIONS THAT DON'T ACTUALLY ALTER THE COMPONENT'S PROPERTIES/VALUES ETC...

        1. Use this if you want to do something on every change detection cycle
            Ex: Inform Angular of some change it could not detect otherwise (this would be a very advanced case)


    4. ngAfterContentInit    
          - Called after ng-content has been projected into view

          When the content about to be projected into ng-view has been initialized   


     5. ngAfterContentChecked    
         - Called every time the projected content (ng-content) has been checked


    6.  ngAfterViewInit
        - Called after component's view (and child views) have been initialized

        i.e. After views have been rendered.


    7.  ngAfterViewChecked
          - Called everytime the view & child views have been checked

          All changes have been checked and accounted for. 


    8.  ngOnDestroy
          - Called once the component is ABOUT to be destroyed

          Ex: Called when ngIf removes a component from the DOM

*/

  ngOnInit() {
  }

// Local Reference
//
// Now we can use the information on the local reference passed in and use the element's properties to get its data

  onAddServer(srvNameInput: HTMLInputElement) {

    // The 'emit' method will EMIT an event of the type we defined above

    this.serverCreated.emit({
      serverName: srvNameInput.value, 

      // ElementRef 
      //'Native element' now gives us access to the UNDERLYING HTML element that ElementRef refers to

      serverContent: this.srvContentInput.nativeElement.value

       //DO NOT USE ELEMENTREF TO CHANGE THE DOM ELEMENT:
       //  DO NOT DO THIS: this.srvContentInput.nativeElement.value = 'Something';
       // Using string interpolation, property binding, etc...
       // We'll learn of a better way further on as well

    });
  }

  onAddBlueprint(srvNameInput: HTMLInputElement) {
    this.bpCreated.emit({
      serverName: srvNameInput.value, 
      serverContent: this.srvContentInput.nativeElement.value
    });
  }

}
