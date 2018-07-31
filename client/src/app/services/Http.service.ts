import {Injectable} from '@angular/core';
import {Observable} from "rxjs/internal/Observable";
import {HttpClient} from "@angular/common/http";
import {User} from "../user";

@Injectable()
export class HttpService {

  private url = 'http://localhost:8080/user';

  constructor(private http: HttpClient) {
  }

  newUserPost() {

  }

  getUsers(): Observable<Array<User>> {
    return this.http.get<Array<User>>(this.url);
  }

  deactivateUser() {

  }


}

