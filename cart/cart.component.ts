import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartproducts: any;
  message!: string;
  purchasedProduct: any;

  constructor(private productService : ProductService) { }

  ngOnInit(): void {
    this.productService.getCartProducts().subscribe(res =>{
      console.log('cart',res);
      this.cartproducts=res;
      
      
    })
  }

  generateBill(cartproduct:any){
    let orderedproduct=[{
      // cartId:cartproduct.productId,
      cartQuantity:cartproduct.cartQuantity,
      productId: cartproduct.productId,
      productName:cartproduct.productName,
      price:cartproduct.price
    }]
    console.log(orderedproduct);
    
    this.productService.putGenerateBill(orderedproduct).subscribe(res=>{
      //this.purchasedProduct=res;
      console.log('result',res);
      this.message="Bill Generated Successfully !!!!!!!!!"
   })
  }

}
