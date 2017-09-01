import { Component, OnInit } from '@angular/core';
import { ServersService } from './servers.service';

// Activated Route is the currently activated route that has loaded the current component

import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {
  private servers: {id: number, name: string, status: string}[] = [];

  constructor(private serversService: ServersService, private router: Router, 
  private route: ActivatedRoute ) { }

  ngOnInit() {
    this.servers = this.serversService.getServers();
  }

  onReload() {

  	//With 'relativeTo' - NOW this command breaks the app
  	//this.route = The current url of the component (thats why it breaks the app)
  	//this.router.navigate(['servers', {relativeTo: this.route}]);
  }
}
