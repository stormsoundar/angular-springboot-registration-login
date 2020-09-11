import { Router } from '@angular/router';
import { Registration } from './../domain/registration';
import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
}) 
export class RegistrationComponent implements OnInit {
  
  public registration = new Registration();
 
  @ViewChild('registrationForm') registrationForm;
  public saveRegistrationUrl = 'http://localhost:8099/registration'; 
  constructor(public httpClient: HttpClient, public router: Router) { }

  ngOnInit(): void {}
  
  public submitDetails() {
    console.log(this.registrationForm); 
    this.httpClient.post<any>(this.saveRegistrationUrl, this.registration).subscribe(registeredInfo => {
      this.registrationForm.resetForm();
      alert("Registered Successfully");
      this.router.navigateByUrl("/login");
    }, error => {
      let errorData = JSON.parse(JSON.parse(JSON.stringify(error))._body);      
      alert(errorData);      
    });
  }
}
