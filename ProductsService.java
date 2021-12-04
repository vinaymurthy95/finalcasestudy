package com.agiliz.stock.service;

import java.util.List;

import com.agiliz.stock.model.Cart_info;
import com.agiliz.stock.model.Products_Info;

public interface ProductsService {

	Products_Info save(Products_Info products_Info);

	Products_Info getProductByName(String productName);

	Products_Info getProductByCategory(String category);

	Products_Info getProductByCompany(String company);

	Products_Info update(int id, Products_Info products_Info);

	List<Products_Info> getAllProducts();

	Cart_info saveToCart(Cart_info cart_info);

	List<Cart_info> getFromCart();

	List<Products_Info> purchaseProduct(List<Cart_info> lCart_infos);


	

}
