package com.pcs.items;

import java.time.LocalDate;

public class ProductSupplement extends ProductBase {
	
	private LocalDate expirationDate;
	
	
	// Constructor
	
	public ProductSupplement(String name, float price, int stock, LocalDate expirationDate) {
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
		
		// Release memory
		report = null;
		
	}

	@Override
	public void verifyExpirationDate() {
		
		LocalDate today = LocalDate.now();
		
	    if (getExpirationDate().equals(today)) {
	        System.out.println("Item expired today.");
	      } else if (getExpirationDate().isBefore(today)) {
		        System.out.println(
		        		"Item has already expired. " +
		        		"Expired on " +
		        		getExpirationDate()
		        		);	      } else {
	        System.out.println(
	        		"Item has not expired yet. " +
	        		"Will expire on " +
	        		getExpirationDate()
	        		);
	     }
	}

}

