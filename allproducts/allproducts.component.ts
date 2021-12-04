import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';


@Component({
  selector: 'app-allproducts',
  templateUrl: './allproducts.component.html',
  styleUrls: ['./allproducts.component.css']
})
export class AllproductsComponent implements OnInit {
  products: any;
  addToCart: any;
  message!: string;

  productUpdating:boolean=false;
   selectedProductToEdit:any;

  constructor(private productService : ProductService) { }

  ngOnInit(): void {
    this.getAllProducts();
  }
  getAllProducts(){
    this.productService.getAllProducts().subscribe(res=>{
      this.products=res;
      console.log('Result',res);
    })
  }

  onEditProduct(product){
    this.selectedProductToEdit=product;
    console.log(this.selectedProductToEdit);
    
  }
  onFormSubmit(){
    this.productUpdating=true;
    this.productService.updateProduct(this.selectedProductToEdit).subscribe(res=>{
             this.message='product updated successfully';
             this.productUpdating=false;
             this.selectedProductToEdit=''
    })
  }

  onClick(product: any){
    let data={
      productId:product.productId,
      productName:product.productName,
      cartQuantity:product.quantity,
      price:product.price
    }
    this.productService.postToCart(data).subscribe(cart=>{
      this.addToCart=cart;
      console.log('cart',cart);
      this.message="Product Added to the Cart Successfully";
      
    })
  }

}
