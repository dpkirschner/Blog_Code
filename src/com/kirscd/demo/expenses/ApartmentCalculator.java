package com.kirscd.demo.expenses;

import java.util.HashMap;
import java.util.Map;

public class ApartmentCalculator {
	private Map<String, Map<String, Integer>> expenses;
	
	public ApartmentCalculator() {
		expenses = new HashMap<String, Map<String, Integer>>();
	}
	
	public void addIndividualTransaction(String fromName, String toName, Integer amount) {
		if(!expenses.containsKey(fromName)) {
			expenses.put(fromName, new HashMap<String, Integer>());
		}
		
		Map<String, Integer> personalExpenses = expenses.get(fromName);
		if(!personalExpenses.containsKey(toName)) {
			personalExpenses.put(toName, 0);
		}
		
		personalExpenses.put(toName, personalExpenses.get(toName) + amount);
	}
	
	public void addTransaction(String fromName, String toName, Integer amount) {
		addIndividualTransaction(fromName, toName, amount);
		addIndividualTransaction(toName, fromName, amount*-1);
	}
	
	public void printTotals() {
		for(String fromName : expenses.keySet()) {
			Map<String, Integer> personalExpenses = expenses.get(fromName);
			
			for(String toName : personalExpenses.keySet()) {
				Integer amount = personalExpenses.get(toName);
				System.out.println(String.format("%s %s %d dollars %s %s this month"
						, fromName
						, amount >= 0 ? "needs to pay" : "needs to collect"
						, Math.abs(amount)
						, amount >= 0 ? "to" : "from"
						, toName));
			}
		}
	}
	
	public static void main(String args[]) {
		ApartmentCalculator myExpenses = new ApartmentCalculator();
		myExpenses.addTransaction("Daniel", "Robert", 10);
		myExpenses.addTransaction("Daniel","David", 20);
		myExpenses.addTransaction("Daniel","Christopher", -30);
		myExpenses.printTotals();
	}
}
