import { Injectable } from '@angular/core';
import { Product } from '../models/product';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  productsArray:Product[] = [];
  constructor(private http:HttpClient) { }

  getAllProducts(){
    let obs = this.http.get<Product[]>("http://localhost:8082/ShoppingAppAPI/request/products");
    obs.subscribe((products: Product[]) => {
      this.productsArray = products;
      console.log(JSON.stringify(this.productsArray));
    }
   
    );
  
  }
}
