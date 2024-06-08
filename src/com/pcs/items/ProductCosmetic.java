package com.pcs.items;

public class ProductCosmetic extends ProductBase {
	
	private String brand;
	
	// Constructor

	public ProductCosmetic(String name, float price, int stock, String brand) {
		super(name, price, stock);
		setBrand(brand);
	}
	
	// Setters and Getters

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	// Methods
	
	@Override
	public void report() {
		
		StringBuilder report = new StringBuilder();
		
		report.append("\n");
		report.append("Name: " + getName() + "\n");
		report.append("Price: $" + getPrice() + "\n");
		report.append("Stock: " + getStock() + " units\n");
		report.append("Brand: " + getBrand() + "\n");

		System.out.println(report.toString());
		
		// Release memory
		report = null;
		
	}
	

}
