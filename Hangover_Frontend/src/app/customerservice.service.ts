import { HttpClient, HttpHeaders } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Customer } from '../classes/Customer';


@Injectable({
  providedIn: 'root'
})
export class CustomerserviceService {
  private resturl: string = 'http://localhost:8080/hangover/customer';
  $isLoggedIn=new EventEmitter();
  
  logIn(customer:any){
    this.$isLoggedIn.emit(customer);
  }

  constructor(private http: HttpClient) {}
  
    
  httpOptions = {
  headers: new HttpHeaders({
  'Content-Type': 'application/json',
  }),
  };
  
   
  getCustomer(): Observable<Customer[]> {
  
  return this.http
  .get<Customer[]>(this.resturl + '/allCustomer').pipe(retry(1), catchError(this.handleError));
  
  }

  addCustomer(customer: any): Observable<Customer[]> {
  
    return this.http
    .post<Customer[]>(this.resturl + '/addCustomer',JSON.stringify(customer),this.httpOptions).pipe(retry(1), catchError(this.handleError));
    
    }

    deleteCustomer(uid: any): Observable<Customer> {
  
      return this.http
      .delete<Customer>(this.resturl + '/deleteCustomer/' + uid,this.httpOptions).pipe(retry(1), catchError(this.handleError));
      
      }

      getACustomer(uid: any): Observable<Customer> {
 
        return this.http
     .get<Customer>(this.resturl + '/searchCustomer/' + uid,this.httpOptions).pipe(retry(1), catchError(this.handleError));
      
      }
     
       

      updateCustomer(customer:any):Observable<Customer>{
        return this.http
        .put<Customer>(this.resturl + '/updateCustomer',JSON.stringify(customer),this.httpOptions).pipe(retry(1), catchError(this.handleError));
      }

      
      validateCustomer(customer:any):Observable<Customer>{
        
        return this.http.post<Customer>(this.resturl + '/validateCustomer',JSON.stringify(customer),this.httpOptions).pipe(retry(1),catchError(this.handleError));
       }
  
   
  handleError(err: { error: { message: string; }; status: any; message: any; }) {
    
  let errorMessage = '';
      
  if (err.error instanceof ErrorEvent) {
   
  errorMessage = err.error.message;
      
  } else {
  
  errorMessage = `Error code : ${err.status} \n Error Message : ${err.message}`;
     
   }
      
  window.alert(errorMessage);
      return throwError(errorMessage);
    
  }
  }