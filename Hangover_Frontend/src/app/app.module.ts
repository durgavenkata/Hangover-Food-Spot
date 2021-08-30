import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { Home2Component } from './home2/home2.component';
import { OrdersComponent } from './orders/orders.component';
import { PaymentComponent } from './payment/payment.component';
import { CustomerserviceService } from './customerservice.service';
import { FormsModule } from '@angular/forms';
import { MenuComponent } from './menu/menu.component';
import { ThankyouComponent } from './thankyou/thankyou.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    Home2Component,
    PaymentComponent,
    AboutusComponent,
    ContactusComponent,
    MenuComponent,
    OrdersComponent,
    ThankyouComponent,

  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule,FormsModule,],
  providers: [CustomerserviceService],
  bootstrap: [AppComponent],
})
export class AppModule {}