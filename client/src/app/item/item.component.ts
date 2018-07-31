import { Component, OnInit } from '@angular/core';
import {HttpService} from "../services/Http.service";

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  constructor(private httpService: HttpService) { }

  public users;

  ngOnInit() {
    this.httpService.getUsers().subscribe(data => {
      if(data){
        this.users = data;
      }else{

      }
    });
  }

  deactivateUser(){
  }

}
