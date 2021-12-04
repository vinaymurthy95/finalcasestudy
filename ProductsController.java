package com.agiliz.stock.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agiliz.stock.model.Cart_info;
import com.agiliz.stock.model.Products_Info;
import com.agiliz.stock.response.Response;
import com.agiliz.stock.service.ProductsService;

@CrossOrigin("*")
@RestController
public class ProductsController {

	@Autowired
	private ProductsService productsService;

	@Autowired
	private Response response;

	@PostMapping("/addProduct")
	public ResponseEntity<Response> addProduct(@RequestBody Products_Info products_Info) {
		Products_Info savePt = productsService.save(products_Info);
		if (savePt != null) {
			response.setStatus(200);
			response.setMessage("product added successfully");
			response.setLisProducts(Arrays.asList(savePt));
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("failed to add may be duplicate");
			response.setLisProducts(null);
			return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	@PostMapping("/addToCart")
	public ResponseEntity<Cart_info> addToCart(@RequestBody Cart_info cart_info) {
		Cart_info savetocart = productsService.saveToCart(cart_info);
		if (savetocart != null) {
			response.setStatus(200);
			response.setMessage(" added to cart successfully");
			return new ResponseEntity<>(savetocart, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("failed to add may be duplicate");
			response.setLisProducts(null);
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/getFromCart")
	public ResponseEntity<List<Cart_info>> getFromCart() {
		List<Cart_info> getfromcart = productsService.getFromCart();
		if (getfromcart != null) {
			response.setStatus(200);
			response.setMessage(" added to cart successfully");
			return new ResponseEntity<>(getfromcart, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("failed to add may be duplicate");
			response.setLisProducts(null);
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/purchaseProduct")
	public ResponseEntity<String> purchaseProduct(@RequestBody List<Cart_info> lCart_infos) {
		List<Products_Info> products_Infos = productsService.purchaseProduct(lCart_infos);
		if (products_Infos != null) {
			response.setStatus(200);
			response.setMessage("product Purchased successfully");
			return new ResponseEntity<>("Bill Generated successfully", HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("not found");
			response.setLisProducts(null);
			return new ResponseEntity<>("Please try again!!!!!!!!!!!!!", HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	

	@GetMapping("/getProductByName/{productName}")
	public ResponseEntity<Response> getProductByName(@PathVariable("productName") String productName) {
		Products_Info products_Info = productsService.getProductByName(productName);
		if (products_Info != null) {
			response.setStatus(200);
			response.setMessage("Product details fetched successfully");
			response.setLisProducts(Arrays.asList(products_Info));
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("Failed to get the product");
			response.setLisProducts(null);
			return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getProductByCategory/{category}")
	public ResponseEntity<Response> getProductByCategory(@PathVariable("category") String category) {
		Products_Info products_Info = productsService.getProductByCategory(category);
		if (products_Info != null) {
			response.setStatus(200);
			response.setMessage("Product details fetched successfully");
			response.setLisProducts(Arrays.asList(products_Info));
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("Failed to get the product");
			response.setLisProducts(null);
			return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getProductByCompany/{company}")
	public ResponseEntity<Response> getProductByCompany(@PathVariable("company") String company) {
		Products_Info products_Info = productsService.getProductByCompany(company);
		if (products_Info != null) {
			response.setStatus(200);
			response.setMessage("Product details fetched successfully");
			response.setLisProducts(Arrays.asList(products_Info));
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("Failed to get the product");
			response.setLisProducts(null);
			return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Products_Info>> getAllProducts() {
		List<Products_Info> liproducts_Info = productsService.getAllProducts();
		if (liproducts_Info != null) {
			response.setStatus(200);
			response.setMessage("Product details fetched successfully");
			return new ResponseEntity<>(liproducts_Info, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("Failed to get the product");
			response.setLisProducts(null);
			return new ResponseEntity<>(liproducts_Info, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updateProduct/{productId}")
	public ResponseEntity<Response> UpdateProduct(@PathVariable("productId") int id,
			@RequestBody Products_Info products_Info) {
		Products_Info updatePt = productsService.update(id, products_Info);
		if (updatePt != null) {
			response.setStatus(200);
			response.setMessage("product updated successfully");
			response.setLisProducts(Arrays.asList(updatePt));
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(404);
			response.setMessage("not found");
			response.setLisProducts(null);
			return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
	}

}
