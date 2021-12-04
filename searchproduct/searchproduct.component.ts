import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-searchproduct',
  templateUrl: './searchproduct.component.html',
  styleUrls: ['./searchproduct.component.css']
})
export class SearchproductComponent implements OnInit {
  productsByName: any=[];
  searchText: any;

  constructor(private productService : ProductService) { }

  ngOnInit(): void {
    
  }

  searchByName(){
    let name = this.searchText
    console.log(name)
    this.productService.getProductByName(name).subscribe(res=>{
      this.productsByName=res;
    })
  }
}

