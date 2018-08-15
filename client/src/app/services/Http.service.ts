import {Injectable} from '@angular/core';
import {Observable} from "rxjs/internal/Observable";
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user";

@Injectable()
export class HttpService {

  private url = 'http://localhost:8080/user';

  constructor(private http: HttpClient) {
  }

  newUserPost(user: User) : Observable<User>{
    console.log(user);
    return this.http.post<User>(this.url + '/createUser', user);
  }

  getUsers(): Observable<Array<User>> {
    return this.http.get<Array<User>>(this.url);
  }

  deactivateUser(user: User) : Observable<User>{
    return this.http.patch<User>(this.url + '/' + user.userId, user);
  }


}

