import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
public customerDetail:any = {customerId:'', name: '', email: '', password: '', phoneNumber:''};

  constructor(public router:Router,public aroute:ActivatedRoute,public service:CustomerserviceService) { }

  ngOnInit(): void {
  }

  newCustomer(){
    this.service.addCustomer(this.customerDetail).subscribe((data : {})=>{this.router.navigate(['/login']);});
  }
}