import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_service/auth.service';

@Component({
  selector: 'orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  constructor(private auth:AuthService){}
  ngOnInit(): void {
    this.OrdersDetails();
    this.loadOrders();
  }
  getOrdersDetails:any=[];
  OrdersDetails(){
    if(localStorage.getItem('localOrders')){
      this.getOrdersDetails=JSON.parse(localStorage.getItem('localOrders')||'[]');
      console.log(this.getOrdersDetails);
    }
  }
  incQnt(menuId: any,qnt: any){
    for(let i=0;i<this.getOrdersDetails.length;i++){
      if(this.getOrdersDetails[i].menuId===menuId){
        if(qnt!=5)
        this.getOrdersDetails[i].qnt=parseInt(qnt)+1;
      }
    }
    localStorage.setItem('localOrders',JSON.stringify(this.getOrdersDetails));
    this.loadOrders();
  }
  decQnt(menuId: any,qnt: any){
    for(let i=0;i<this.getOrdersDetails.length;i++){
      if(this.getOrdersDetails[i].menuId===menuId){
        if(qnt!=1)
        this.getOrdersDetails[i].qnt=parseInt(qnt)-1;
      }
    }
    localStorage.setItem('localOrders',JSON.stringify(this.getOrdersDetails));
    this.loadOrders();
  }
  total:number=0;
  loadOrders(){
    if(localStorage.getItem('localOrders')){
      this.getOrdersDetails=JSON.parse(localStorage.getItem('localOrders')||'[]');
      this.total=this.getOrdersDetails.reduce(function(acc: any,val: any){
        return acc+(val.amt*val.qnt);
      },0)
        
      
    }
  }
  removeall(){
    localStorage.removeItem('localOrders');
    this.getOrdersDetails=[];
    this.total=0;
    this.ordersNumber=0;
    this.auth.ordersSubject.next(this.ordersNumber);
  }
   singleDelete(getOrdersDetail: any){
    console.log(getOrdersDetail);
    if(localStorage.getItem('localOrders')){
      this.getOrdersDetails=JSON.parse(localStorage.getItem('localOrders')||'[]');
      for(let i=0;i<this.getOrdersDetails.length;i++){
        if(this.getOrdersDetails[i].menuId===getOrdersDetail){
          this.getOrdersDetails.splice(i,1);
          localStorage.setItem('localOrders',JSON.stringify(this.getOrdersDetails));
          this.loadOrders();
          this.ordersNumberFunc();
        }
      }
    }
  }
    
  ordersNumber:number=0;
  ordersNumberFunc(){
    var ordersValue=JSON.parse(localStorage.getItem('localOrders')||'[]');
    this.ordersNumber=ordersValue.length;
    this.auth.ordersSubject.next(this.ordersNumber);
    
  }
  }