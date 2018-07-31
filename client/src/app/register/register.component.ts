import { Component, OnInit } from '@angular/core';
import {HttpService} from "../services/Http.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private httpService: HttpService) { }

  ngOnInit() {
  }

}
