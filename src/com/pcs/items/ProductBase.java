package com.pcs.items;

import java.time.LocalDate;

import com.pcs.interfaces.Product;

public abstract class ProductBase implements Product {
	
	private String name;
	private float price;
	private int stock;
	
	
	// Constructor
	
	public ProductBase(String name, float price, int stock) {
		setName(name);
		setPrice(price);
		setStock(stock);
	}
	
	
	// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Value cannot be negative or zero.");
		} else {
			this.price = price;
		}	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (stock < 0) {
			throw new IllegalArgumentException("Value cannot be negative.");
		} else {
			this.stock = stock;
		}
	}
	
	
	// Methods

	public void sell(int saleStock) {
		
		if (saleStock > getStock() ) {
			
		    throw new IllegalArgumentException("Sale cannot be higher than currrent stock.");
			
		} else {
			
			setStock( getStock() - saleStock );
			
		}
		
	}

	public void report() {}
	
	public void verifyExpirationDate() {}
	
	public LocalDate getExpirationDate() {
		return null;
	}

}
