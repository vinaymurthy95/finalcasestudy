package com.agiliz.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agiliz.stock.model.Cart_info;

public interface CartRepository extends JpaRepository<Cart_info, Integer> {

}
