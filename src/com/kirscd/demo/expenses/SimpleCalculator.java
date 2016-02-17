package com.kirscd.demo.expenses;

import java.util.HashMap;
import java.util.Map;

public class SimpleCalculator {
	private Map<String, Integer> expenses;
	
	public SimpleCalculator() {
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
			System.out.println(String.format("I %s %d dollars %s %s this month"
					, amount >= 0 ? "need to pay" : "need to collect"
					, Math.abs(amount)
					, amount >= 0 ? "to" : "from"
					, name));
		}
	}
	
	public static void main(String args[]) {
		SimpleCalculator myExpenses = new SimpleCalculator();
		myExpenses.addTransaction("Robert", 10);
		myExpenses.addTransaction("David", 20);
		myExpenses.addTransaction("Christopher", -30);
		myExpenses.printTotals();
	}
}
