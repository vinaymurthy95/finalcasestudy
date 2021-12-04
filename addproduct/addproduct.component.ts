import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {
  message!: string;

  constructor(private productService :ProductService) { }

  ngOnInit(): void {
  }

  onFormSubmit(addProductForm : NgForm){
    this.productService.postProducts(addProductForm.value).subscribe(res =>{
      console.log(res);
      addProductForm.reset();
      this.message="Product Added Successfully"     
    })
  }

}
