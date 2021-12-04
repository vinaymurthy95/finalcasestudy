package com.agiliz.stock.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.agiliz.stock.model.Products_Info;

@Component
public class Response {
	private int status;
	private String message;
	private List<Products_Info> lisProducts;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Products_Info> getLisProducts() {
		return lisProducts;
	}

	public void setLisProducts(List<Products_Info> lisProducts) {
		this.lisProducts = lisProducts;
	}

}
