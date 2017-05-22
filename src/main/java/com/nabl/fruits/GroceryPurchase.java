package com.nabl.fruits;

public class GroceryPurchase {
	int number_apples = 0;
	int number_oranges = 0;
	String costApplesAndOranges = "";

	public int getNumber_apples() {
		return number_apples;
	}

	public void setNumber_apples(int number_apples) {
		this.number_apples = number_apples;
	}

	public int getNumber_oranges() {
		return number_oranges;
	}

	public void setNumber_oranges(int number_oranges) {
		this.number_oranges = number_oranges;
	}

	public String getCostApplesAndOranges() {
		return costApplesAndOranges;
	}

	public void setCostApplesAndOranges(String costApplesAndOranges) {
		this.costApplesAndOranges = costApplesAndOranges;
	}

	@Override
	public String toString() {
		return "GroceryPurchase [number_apples=" + number_apples + ", number_oranges=" + number_oranges
				+ ", costApplesAndOranges=" + costApplesAndOranges + "]";
	}

}
