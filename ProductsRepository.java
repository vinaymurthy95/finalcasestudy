package com.agiliz.stock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agiliz.stock.model.Products_Info;

public interface ProductsRepository extends JpaRepository<Products_Info, Integer> {

	Optional<Products_Info> findByproductName(String productName);

	Optional<Products_Info> findBycategory(String category);

	Optional<Products_Info> findBycompany(String company);

	Products_Info findByproductId(int productId);

}
