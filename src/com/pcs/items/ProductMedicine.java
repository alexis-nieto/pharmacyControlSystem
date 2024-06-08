package com.pcs.items;

import java.time.LocalDate;

public class ProductMedicine extends ProductBase {
	
	private LocalDate expirationDate;
	
	// Constructor

	public ProductMedicine(String name, float price, int stock, LocalDate expirationDate) {
		super(name, price, stock);
		this.expirationDate = expirationDate;
	}
	
	// Getters and Setters

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	// Methods
	
	@Override
	public void report() {
		
		StringBuilder report = new StringBuilder();
		
		report.append("\n");
		report.append("Name: " + getName() + "\n");
		report.append("Price: $" + getPrice() + "\n");
		report.append("Stock: " + getStock() + " units\n");
		report.append("Exp. Date: " + getExpirationDate() + "\n");

		
		System.out.println(report.toString());
		
	}
	

}
