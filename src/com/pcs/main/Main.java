package com.pcs.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.pcs.items.*;

public class Main {

	public static void main(String[] args) {
				
		List<ProductBase> inventory = new ArrayList<>();
		
		inventory.add(new ProductMedicine("Pfizer Paracetamol", 10.95f, 7, dateBuilder("2024-05-04")));
		inventory.add(new ProductMedicine("Astra Zeneca Ibuprofen", 14.34f, 4, dateBuilder("2025-06-04")));
		inventory.add(new ProductMedicine("Bayer Aspirin", 8.53f, 15, dateBuilder("2026-09-04")));
		inventory.add(new ProductCosmetic("Lotion", 15.99f, 15, "Bodyworks"));
		inventory.add(new ProductCosmetic("Eye Shadow", 67.99f, 15, "MAC"));
		inventory.add(new ProductCosmetic("Shampoo", 102.99f, 15, "L\'orea"));
		inventory.add(new ProductCosmetic("Shampoo", 92.99f, 15, "Caprice"));
		inventory.add(new ProductCosmetic("Lipstick ", 159.99f, 15, "Maybelline"));
		inventory.add(new ProductSupplement("ON Protein Milkshake", 140.95f, 3, dateBuilder("2027-03-24")));
		inventory.add(new ProductSupplement("Pfizer Vitamin C", 10.95f, 7, dateBuilder("2025-12-15")));
		inventory.add(new ProductSupplement("Protein Milkshake", 10.95f, 7, dateBuilder("2026-09-01")));

		showInventory(inventory);
		searchInventory(inventory, "Pfizer");
		searchInventory(inventory, "sHampO");
		
		// Demo of Selling
		
		inventory.get(0).report();
		inventory.get(0).sell(5);
		inventory.get(0).report();
		
	}
	
	public static LocalDate dateBuilder(String date){
		
		LocalDate localDate = LocalDate.parse(date);
		
		return localDate;
		
	}
	
	
	public static void showInventory(List<ProductBase> inventory){
		
		for (ProductBase currentItem : inventory) {
			
			currentItem.report();
			
		}
		
	}
	
	public static void searchInventory(List<ProductBase> inventory, String keyword){
		
		long i = 0;
		
		for (ProductBase currentItem : inventory) {
			
			// Check if keyword is present on the names of all the 
			
			boolean match = currentItem.getName().toLowerCase().contains(keyword.toLowerCase());
			
			if (match) {
				i++;
				System.out.println("\n>>> Match " + i + ":");
				currentItem.report();
			}
			
		}
		
	}

}

