package com.kirscd.demo.expenses;

import java.util.HashMap;
import java.util.Map;

public class ApartmentCalculatorWithPot {
	private Map<String, Integer> expenses;
	
	public ApartmentCalculatorWithPot() {
		expenses = new HashMap<String, Integer>();
	}
	
	public void addTransaction(String name, Integer amount) {
		if(!expenses.containsKey(name)) {
			expenses.put(name, 0);
		}
		
		expenses.put(name, expenses.get(name) + amount);
	}
	
	public void printTotals() {
		for(String name : expenses.keySet()) {
			Integer amount = expenses.get(name);
			System.out.println(String.format("%s %s %d dollars %s the pot this month"
					, name
					, amount >= 0 ? "needs to pay" : "needs to collect"
					, Math.abs(amount)
					, amount >= 0 ? "into" : "from"));
		}
	}
	
	public static void main(String args[]) {
		ApartmentCalculatorWithPot myApartmentExpenses = new ApartmentCalculatorWithPot();
		myApartmentExpenses.addTransaction("Robert", 10);
		myApartmentExpenses.addTransaction("David", 20);
		myApartmentExpenses.addTransaction("Christopher", -40);
		myApartmentExpenses.addTransaction("Daniel", 10);
		myApartmentExpenses.printTotals();
	}
}
