package com.nabl.fruits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CostCalculator {

	int number_apples = 0;
	int number_oranges = 0;
	String costApplesAndOranges = "";
	GroceryPurchase grocery;

	public String StartProcess(String fileName, boolean discountSeason) {

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {

				number_apples = line.equals("apple") ? ++number_apples : number_apples;
				number_oranges = line.equals("orange") ? ++number_oranges : number_oranges;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		grocery = new GroceryPurchase();
		grocery.setNumber_apples(number_apples);
		grocery.setNumber_oranges(number_oranges);

		if (discountSeason) {
			costApplesAndOranges = simpleCost(grocery.number_apples, grocery.number_oranges);

		} else {
			costApplesAndOranges = discountedCost(grocery.number_apples, grocery.number_oranges);

		}
		System.out.println("Discounted Cost : " + costApplesAndOranges);
		grocery.setCostApplesAndOranges(costApplesAndOranges);
		System.out.println(grocery);

		return costApplesAndOranges;

	}

	public String simpleCost(int apples, int oranges) {

		double simpleCost = apples * 0.60 + oranges * 0.25;
		return "£ " + simpleCost;

	}

	public String discountedCost(int apples, int oranges) {

		double cost_apples = apples % 2 == 0 ? ((apples / 2) * 0.6) : (0.6 + (apples / 2) * 0.6);

		int packsOfOranges = oranges / 3;
		int remainderOranges = oranges % 3;
		double cost_oranges = packsOfOranges * 0.50 + remainderOranges * 0.25;
		double totalCost = cost_apples + cost_oranges;
		return "£ " + totalCost;

	}

}
