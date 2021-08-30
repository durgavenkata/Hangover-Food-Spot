import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

public logcred:any = {email:'',password:''};
msg='';
checking:any = {email:'',password:''};


  constructor(public router:Router,public aroute:ActivatedRoute,public service:CustomerserviceService) { }

  ngOnInit(): void {
    
  }

  validateCustomer(){

this.service.validateCustomer(this.logcred).subscribe(data=>(this.checking=data));

    if(this.checking.email == ""  &&  this.checking.password == "" ){
      this.router.navigate(['/login']);
     this.msg="Invalid Username or Password";
    }else{
      this.router.navigate(['/home2']);
      
    }
    console.log(this.checking);
    this.service.logIn(this.checking);
  }
  
}

