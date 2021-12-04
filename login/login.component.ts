import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: any;
  password: any;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  login()
{
  if(this.username == "vinay" && this.password == "123"){
    this.router.navigate(['/home'])
  } else {
    alert("Invalid Credentials !!")
    this.username=""
    this.password=""
  }
}
}
