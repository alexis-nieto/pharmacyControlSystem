package com.pcs.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.pcs.annotations.IgnoreExpiration;
import com.pcs.enums.ItemType;
import com.pcs.items.*;

public class Main {

	private static List<ProductBase> inventory = new ArrayList<>();

	public static void main(String[] args) {

		// Adding Items

		addItem(ItemType.MEDICINE, "Pfizer Paracetamol", 10.95f, 7, "2024-05-04");
		addItem(ItemType.COSMETIC, "Lotion", 15.99f, 15, "Bodyworks");
		addItem(ItemType.SUPPLEMENT, "ON Protein Milkshake", 140.95f, 3, "2027-03-24");
		addItem(ItemType.MEDICINE, "Astra Zeneca Ibuprofen", 14.34f, 4, "2024-06-07");
		addItem(ItemType.COSMETIC, "Eye Shadow", 67.99f, 15, "MAC");
		addItem(ItemType.COSMETIC, "Shampoo", 102.99f, 15, "L\'orea");
		addItem(ItemType.MEDICINE, "Bayer Aspirin", 8.53f, 15, "2026-09-04");
		addItem(ItemType.COSMETIC, "Shampoo", 42.99f, 15, "Vanart");
		addItem(ItemType.SUPPLEMENT, "Pfizer Vitamin C", 10.95f, 7, "2025-12-15");
		addItem(ItemType.COSMETIC, "Shampoo", 92.99f, 15, "Caprice");
		addItem(ItemType.SUPPLEMENT, "Protein Milkshake", 10.95f, 7, "2023-09-01");
		addItem(ItemType.COSMETIC, "Lipstick ", 159.99f, 15, "Maybelline");

		// All inventory:
		showInventory(inventory);

		separator((byte) 72);

		// Search for an Item.

		searchInventory(inventory, "Pfizer ");

		searchInventory(inventory, "sHampO");

		separator((byte) 72);

		// Demo of Selling

		inventory.get(0).report();
		inventory.get(0).sell(5);
		inventory.get(0).report();
		// inventory.get(0).sell(5);

		separator((byte) 72);

		// Check all expiration dates

		checkExpirationAllInventory(inventory);

	}

	private static void separator(byte qty) {

		System.out.print("\n");

		for (byte i = 0; i < qty; i++) {

			System.out.print("#");

		}

		System.out.print("\n");

	}

	private static LocalDate dateBuilder(String date) {

		LocalDate localDate = LocalDate.parse(date);

		return localDate;

	}

	private static void addItem(ItemType type, String name, float price, int stock, String extra) {

		switch (type) {
		case MEDICINE: {
			inventory.add(new ProductMedicine(name, price, stock, dateBuilder(extra)));
			break;
		}
		case COSMETIC: {
			inventory.add(new ProductCosmetic(name, price, stock, extra));
			break;
		}
		case SUPPLEMENT: {
			inventory.add(new ProductSupplement(name, price, stock, dateBuilder(extra)));
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}

	}

	private static void showInventory(List<ProductBase> inventory) {

		for (ProductBase currentItem : inventory) {

			currentItem.report();

		}

	}

	private static void searchInventory(List<ProductBase> inventory, String keyword) {

		long i = 0;

		for (ProductBase currentItem : inventory) {

			// Check if keyword is present on the names of all the items.

			boolean match = currentItem.getName().toLowerCase().contains(keyword.toLowerCase());

			if (match) {
				i++;
				System.out.println("\n>>> Match " + i + ":");
				currentItem.report();
			}

		}

	}

	private static void checkExpirationAllInventory(List<ProductBase> inventory) {

		LocalDate today = LocalDate.now();

		for (ProductBase currentItem : inventory) {

			// If object's class has the IgnoreExpiration annotation
			// will be ignored by this method.

			if (currentItem.getClass().isAnnotationPresent(IgnoreExpiration.class)) {
				continue;
				
			} else {
				
				if (currentItem.getExpirationDate().equals(today)) {
					
					currentItem.report();
					System.out.println("Item expired today.");
					
				} else if (currentItem.getExpirationDate().isBefore(today)) {
					
					currentItem.report();
					System.out.println("Item has already expired. " + "Expired on " + currentItem.getExpirationDate());
				
				} else {continue;}
				
			separator((byte) 10);
				
			}

		}

	}

}
