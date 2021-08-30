import { Component } from '@angular/core';
import { AuthService } from './_service/auth.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'foodordering';
  constructor(private auth:AuthService){
    this.auth.ordersSubject.subscribe((data)=>{
      this.ordersItem=data;
    });
  }
  ngOnInit():void{
    this.ordersItemFunc();
  }
  ordersItem:number=0;
  ordersItemFunc=()=>{
    if(localStorage.getItem('localOrders')!=null){

      var ordersCount=JSON.parse(localStorage.getItem('localOrders')||'[]');
      
      this.ordersItem=ordersCount.length;
    }

  }
}