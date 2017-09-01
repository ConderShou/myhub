import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { ServersService } from '../servers.service';
import { CanComponentDeactivate } from './can-deactivate-guard.service';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-edit-server',
  templateUrl: './edit-server.component.html',
  styleUrls: ['./edit-server.component.css']
})
export class EditServerComponent implements OnInit, CanComponentDeactivate {
  server: {id: number, name: string, status: string};
  serverName = '';
  serverStatus = '';

  allowEdit = false;

  changesSaved = false;

  constructor(private serversService: ServersService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {

    // 1st Method of Accessing Query Params & Fragments
    //    - This won't allow you to access any changes AFTER the component has been loaded
    // this.route.snapshot.queryParams
    // this.route.snapshot.fragment

    // 2nd Method - Subscribe to these Params

    this.route.queryParams.subscribe(
       (queryParams: Params) => {
         this.allowEdit = queryParams['allowEdit'] === '1' ? true : false;
       }
      );
    this.route.fragment.subscribe();

    const id = +this.route.snapshot.params['id'];
    this.server = this.serversService.getServer(id);

    this.route.params.subscribe(
      (params: Params) => {
         this.server = this.serversService.getServer(+params['id'])
      });

    this.serverName = this.server.name;
    this.serverStatus = this.server.status;
  }

  onUpdateServer() {
    this.serversService.updateServer(this.server.id, {name: this.serverName, status: this.serverStatus});

    //Allows user to leave this route
    this.changesSaved = true;
    this.router.navigate(['../'], {relativeTo: this.route});
  }

  canDeactivate(): Observable<boolean> | Promise<boolean> | boolean {

    if (!this.allowEdit) {
      return true;
    }
    // serverName will change when the user types into the textfield due to Two-Way Binding
    if ((this.serverName !== this.server.name || this.serverStatus !== this.server.status) && !this.changesSaved) {
      return confirm('Do you want to discard the changes?');
    } else {
      return true;
    }   
  }

}
