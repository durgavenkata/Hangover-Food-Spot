import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'; // CLI imports router
import { AboutusComponent } from './aboutus/aboutus.component';
import { PaymentComponent } from './payment/payment.component';
import { ContactusComponent } from './contactus/contactus.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent} from './register/register.component';
import { Home2Component} from './home2/home2.component';
import { MenuComponent} from './menu/menu.component';
import { OrdersComponent } from './orders/orders.component';
import { ThankyouComponent } from './thankyou/thankyou.component';

const routes: Routes = [
  { path: 'contactus', component: ContactusComponent },
  { path: 'aboutus', component: AboutusComponent },
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegisterComponent},
  {path: 'home2', component:Home2Component},
  {path: 'payment', component:PaymentComponent},
  {path: 'menu', component:MenuComponent},
  {path: 'orders', component:OrdersComponent},
  {path: 'thankyou', component:ThankyouComponent},
]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

export const routingComponents = [
  AboutusComponent,
  ContactusComponent,
  LoginComponent,
  RegisterComponent,
  Home2Component,
  PaymentComponent,
  ThankyouComponent
  
];