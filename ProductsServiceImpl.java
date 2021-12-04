package com.agiliz.stock.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agiliz.stock.model.Cart_info;
import com.agiliz.stock.model.Products_Info;
import com.agiliz.stock.repository.CartRepository;
import com.agiliz.stock.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Products_Info save(Products_Info products_Info) {
		List<Products_Info> list = productsRepository.findAll();
		if (list.contains(products_Info)) {
			return null;
		} else {
			return productsRepository.save(products_Info);
		}
	}

	@Override
	public Products_Info update(int id, Products_Info products_Info) {
		Products_Info updatePt = productsRepository.findById(id).orElse(null);
		if (updatePt != null) {
			updatePt.setProductName(products_Info.getProductName());
			updatePt.setCategory(products_Info.getCategory());
			updatePt.setCompany(products_Info.getCompany());
			updatePt.setQuantity(products_Info.getQuantity());
			updatePt.setPrice(products_Info.getPrice());
			return productsRepository.save(updatePt);
		}
		return null;
	}

	@Override
	public Products_Info getProductByName(String productName) {
		return productsRepository.findByproductName(productName).orElse(null);
	}

	@Override
	public Products_Info getProductByCategory(String category) {
		return productsRepository.findBycategory(category).orElse(null);
	}

	@Override
	public Products_Info getProductByCompany(String company) {
		return productsRepository.findBycompany(company).orElse(null);
	}

	@Override
	public List<Products_Info> getAllProducts() {
		return productsRepository.findAll();
	}

	@Override
	public Cart_info saveToCart(Cart_info cart_info) {
		return cartRepository.save(cart_info);
	}

	@Override
	public List<Cart_info> getFromCart() {
		return cartRepository.findAll();
	}

	@Override
	public List<Products_Info> purchaseProduct(List<Cart_info> lCart_infos) {
		List<Products_Info> products_Infos = new ArrayList<>();
		for(Cart_info info : lCart_infos) {
			Products_Info info2 =  productsRepository.findByproductId(info.getProductId());
			int quantity = info2.getQuantity()-info.getCartQuantity();
			info2.setQuantity(quantity);
			productsRepository.save(info2);
			products_Infos.add(info2);
		}
		return products_Infos;	
	}



}
