package com.pcs.main;

import java.time.LocalDate;

import com.pcs.items.*;

public class Main {

	public static void main(String[] args) {
		
		LocalDate expirationDate = LocalDate.of(2000, 06, 21);
		
		ProductMedicine medicine = new ProductMedicine("Testinol", 10.95f, 7, expirationDate);
		
		medicine.report();
		
	}

}
