package com.nabl.fruitsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nabl.fruits.CostCalculator;
import com.nabl.fruits.GroceryPurchase;

public class CostCalculatorTest {

	@Test
	public void testStartProcess_yesDiscount() {
		CostCalculator costCalculator = new CostCalculator();
		String fileName = "C:/Users/Rahul/workspace/JBDS_Suite/Test/src/purchase.txt";
		boolean discountSeason = true;// SEASONS DISCOUNT
		String calculatedDiscountedCost = costCalculator.StartProcess(fileName, discountSeason);
		assertEquals("£ 3.4", calculatedDiscountedCost);

	}

	@Test
	public void testStartProcess_NoDiscount() {
		CostCalculator costCalculator = new CostCalculator();
		String fileName = "C:/Users/Rahul/workspace/JBDS_Suite/Test/src/purchase.txt";
		boolean discountSeason = false;// SEASONS DISCOUNT
		String calculatedSimpleCost = costCalculator.StartProcess(fileName, discountSeason);
		assertEquals("£ 1.95", calculatedSimpleCost);

	}

	@Test
	public void testSimpleCost() {
		CostCalculator costCalculator = new CostCalculator();
		GroceryPurchase grocery = new GroceryPurchase();
		grocery.setNumber_apples(3);
		grocery.setNumber_oranges(1);
		String calculatedSimpleCost = costCalculator.simpleCost(grocery.getNumber_apples(),
				grocery.getNumber_oranges());

		assertEquals("£ 2.05", calculatedSimpleCost);

	}

	@Test
	public void testDiscountedCost() {
		CostCalculator costCalculator = new CostCalculator();
		GroceryPurchase grocery = new GroceryPurchase();
		grocery.setNumber_apples(4);// 1.2
		grocery.setNumber_oranges(4);// 0.5 + 0.25 = .75
		String calculatedDiscountedCost = costCalculator.discountedCost(grocery.getNumber_apples(),
				grocery.getNumber_oranges());
		assertEquals("£ 1.95", calculatedDiscountedCost);

	}

}
