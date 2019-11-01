import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products:Product[] = [];
  constructor(private productService:ProductService) { }

  ngOnInit() {
    this.products.push({title: 'first',price: 5,category: "fruit",imageUrl: "https://images.unsplash.com/photo-1558384361-b91c10b09443?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"});
    this.products.push({title: 'first',price: 5,category: "fruit",imageUrl: "https://images.unsplash.com/photo-1558384361-b91c10b09443?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"});
    this.products.push({title: 'first',price: 5,category: "fruit",imageUrl: "https://images.unsplash.com/photo-1558384361-b91c10b09443?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"});
    this.products.push({title: 'first',price: 5,category: "fruit",imageUrl: "https://images.unsplash.com/photo-1558384361-b91c10b09443?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"});

    this.productService.getAllProducts();
  }

}
