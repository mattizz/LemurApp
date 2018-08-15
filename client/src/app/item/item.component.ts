import { Component, OnInit } from '@angular/core';
import {HttpService} from "../services/Http.service";
import {RunsType} from "../models/runs-type.enum";

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  constructor(private httpService: HttpService) { }

  public users;
  public userId: number[];
  public kindsRoutes = RunsType;

  ngOnInit() {
    this.httpService.getUsers().subscribe(data => {
      if(data){
        this.users = data;
      }
    });
  }

  deactivateUser(userNumber: number){
    /*var userToUpdate = this.users[];

    userToUpdate.active = false;
    this.httpService.deactivateUser(userToUpdate).subscribe(data => {
      console.log(userToUpdate.userId);
      console.log(userToUpdate);
    });*/

    console.log("user number: " + userNumber);
  }
}
