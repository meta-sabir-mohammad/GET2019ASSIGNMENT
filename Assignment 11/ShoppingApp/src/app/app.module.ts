import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { ProductsComponent } from './component/products/products.component';
import {RouterModule} from '@angular/router';
import { ProductCardComponent } from './component/product-card/product-card.component';
import { ProductQuantityComponent } from './component/product-quantity/product-quantity.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ProductsComponent,
    ProductCardComponent,
    ProductQuantityComponent,
     ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: 'products', component: ProductsComponent}
    ]),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
