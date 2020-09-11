
import { HttpClient } from '@angular/common/http';
import { User } from './../domain/user';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user = new User();
  public loginUrl = 'http://localhost:8099/login';
  constructor(public httpClient: HttpClient, public router: Router) { }

  ngOnInit(): void {
  }

  public login(user: User) {
    this.httpClient.post(this.loginUrl, user).subscribe((userObject) => {
      console.log(userObject);
      if (userObject === null) {
        alert("Wrong Username or Password");
      }
      this.user = JSON.parse(JSON.stringify(userObject))._body;      
      if (this.user !== null) {        
        alert("Login Successfully");
        this.router.navigateByUrl("/home");
      }       
    }, error => {
      let errorData = JSON.parse(JSON.stringify(error))._body;
      alert("Invalid Credintials");
    });
  }

}
