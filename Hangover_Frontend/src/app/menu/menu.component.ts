import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_service/auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  ordersDataNull: undefined;

  constructor(private auth:AuthService) { }

  ngOnInit(): void {
  }
  url:string="../assets/wood_1.jpg";
  changeImage(event:any){
    this.url= event.target.src;
    
  }
  menuArray=[
    
    {
      menuId:1,
      img:'../assets/Veg roll.jpg',
    amt:120,
    qnt:1
  },
  {
    menuId:2,
    img:'../assets/Veg pizza.jpg',
  amt:200,
  qnt:1
},
{
  menuId:3,
  img:'../assets/Veg burger.jpg',
amt:180,
qnt:1
},
{
  menuId:4,
  img:'../assets/Chicken burgger.jpg',
amt:280,
qnt:1
},
{
  menuId:5,
  img:'../assets/Chicken popcorn.jpg',
amt:200,
qnt:1
},
{
  menuId:6,
  img:'../assets/Chicken roll.jpg',
amt:220,
qnt:1
},
{
  menuId:7,
  img:'../assets/Chicken tikka.jpg',
amt:280,
qnt:1
},
{
  menuId:8,
  img:'../assets/Mocktails.jpg',
amt:150,
qnt:1
},
{
  menuId:9,
  img:'../assets/Milkshake.jpg',
amt:180,
qnt:1
},
{
  menuId:10,
  img:'../assets/Soft drinks.jpg',
amt:80,
qnt:1
},
    
    
    
  ];
  inc(menu: { qnt: any; }){
    //console.log(menu.qnt);
    if(menu.qnt!=5){
    menu.qnt=menu.qnt+1;
    }
  }
  dec(menu: { qnt: any; }){
    //console.log(menu.qnt);
    if(menu.qnt!=1){
      menu.qnt=menu.qnt-1;
    }
  }
  itemsOrders:any=[];
  Orders(category: { menuId: any; qnt: any; }){
    console.log(category);
    let ordersDataNull=localStorage.getItem('localOrders');
    if(ordersDataNull==null){
      let storeDataGet:any=[];
      storeDataGet.push(category);
      localStorage.setItem('localOrders',JSON.stringify(storeDataGet));
    }
    else{
      var id=category.menuId;
      let index:number=-1;
      this.itemsOrders=JSON.parse(localStorage.getItem('localOrders')||'[]');
      for(let i=0;i<this.itemsOrders.length;i++){
        if(parseInt(id)===parseInt(this.itemsOrders[i].menuId)){
          this.itemsOrders[i].qnt=category.qnt;
          index=i;
          break;
          
        }
      }
      if(index==-1){
        this.itemsOrders.push(category);
        localStorage.setItem('localOrders',JSON.stringify(this.itemsOrders));
      }
      else{
        localStorage.setItem('localOrders',JSON.stringify(this.itemsOrders));
      }
    }
    
    this.ordersNumberFunc();
  }
  ordersNumber:number=0;
  ordersNumberFunc(){
    var ordersValue=JSON.parse(localStorage.getItem('localOrders')||'[]');
    this.ordersNumber=ordersValue.length;
    this.auth.ordersSubject.next(this.ordersNumber);
    
  }


}