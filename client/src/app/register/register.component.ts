import { Component, OnInit } from '@angular/core';
import {HttpService} from "../services/Http.service";
import {User} from "../models/user";
import {RunsType} from "../models/runs-type.enum";
import {NgForm} from '@angular/forms'
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newUser = <User>{};
  kindsRoutes = RunsType;
  isPay = {'pay': true, "notPay": false}

  defaultPayment = true;
  defaultRoutes = this.kindsRoutes.Średnia;

  constructor(private httpService: HttpService) { }

  ngOnInit(){

  }

  onSubmit(form: NgForm){
      this.newUser.firstName = form.value.firstName;
      this.newUser.lastName = form.value.lastName;
      this.newUser.identityCardNumber = form.value.identityCardNumber;
      this.newUser.run = form.value.routeType;
      this.newUser.pay = form.value.payment;
      this.newUser.additionalText = form.value.additionalText;
      return this.httpService.newUserPost(this.newUser).subscribe(data => {});

  }

  enumRoutesValues() : Array<string> {
    return Object.keys(this.kindsRoutes);
  }

  payValues(){
    return Object.keys(this.isPay);
  }
}
