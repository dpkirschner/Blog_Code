package com.kirscd.demo.expenses;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ApartmentCalculatorWithReconciliation {
	private Map<String, Integer> expenses;
	
	public ApartmentCalculatorWithReconciliation() {
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
	
	/**
	 * produces a, correct, but not randomly chosen number of transactions dependent on how the queues
	 * are built initially.
	 */
	public void printIndividualTransactions() {
		Queue<ExpenseTotal> debts = new ArrayDeque<ExpenseTotal>();
		Queue<ExpenseTotal> credits = new ArrayDeque<ExpenseTotal>();
		buildStructures(debts, credits);
		
		reconcileCreditsDebts(credits, debts);

	}
	
	/**
	 * Produces the minimum number of transactions by using a priority queue to match the 
	 * highest credits with the highest debts.
	 */
	public void printMinimumIndividualTransactions() {
		Comparator<ExpenseTotal> maxComparator = (ExpenseTotal o1, ExpenseTotal o2) -> o1.amount.compareTo(o2.amount);
		//maximum credit bubbles to the top
		PriorityQueue<ExpenseTotal> credits 
			= new PriorityQueue<ExpenseTotal>(maxComparator);
		//maximum debt bubbles to the top (note reverse of comparator)
		PriorityQueue<ExpenseTotal> debts 
			= new PriorityQueue<ExpenseTotal>(maxComparator.reversed());
		
		buildStructures(debts, credits);
		
		reconcileCreditsDebts(credits, debts);
	}

	/**
	 * @param debts
	 * @param credits
	 */
	private void buildStructures(Queue<ExpenseTotal> debts, Queue<ExpenseTotal> credits) {
		expenses.keySet()
			.stream()
			.map(name -> new ExpenseTotal(name, expenses.get(name)))
			.forEach(expenseTotal -> {
				if(expenseTotal.amount > 0) {
					credits.add(expenseTotal);
				} else if(expenseTotal.amount < 0) {
					debts.add(expenseTotal);
				}
			});
	}

	/**
	 * @param credits
	 * @param debts
	 */
	private void reconcileCreditsDebts(Queue<ExpenseTotal> credits, Queue<ExpenseTotal> debts) {
		while(!debts.isEmpty()) {
			ExpenseTotal currentDebt = debts.remove();
			ExpenseTotal currentCredit = credits.remove();
			
			System.out.println(String.format("%s will pay %s %d dollars"
					, currentDebt.name
					, currentCredit.name
					, Math.min(Math.abs(currentDebt.amount), currentCredit.amount)));
			
			//these two cancel each other out so do nothing
			if(currentDebt.amount == currentCredit.amount) {
				continue;
			}
			
			if(Math.abs(currentDebt.amount) > currentCredit.amount) {
				//debt amount was higher was add a new debt with the remaining balance
				debts.add(new ExpenseTotal(currentDebt.name, currentDebt.amount + currentCredit.amount));
			} else {
				//credit amount was higher so 
				credits.add(new ExpenseTotal(currentCredit.name, currentDebt.amount + currentCredit.amount));
			}
		}
	}
	
	public class ExpenseTotal {
		public String name;
		public Integer amount;
		
		public ExpenseTotal(String name, Integer amount) {
			this.name = name;
			this.amount = amount;
		}
	}
	
	public static void main(String args[]) {
		ApartmentCalculatorWithReconciliation myApartmentExpenses = new ApartmentCalculatorWithReconciliation();
		myApartmentExpenses.addTransaction("Daniel", -10);
		myApartmentExpenses.addTransaction("Robert", -10);
		myApartmentExpenses.addTransaction("David", 5);
		myApartmentExpenses.addTransaction("Christopher", 15);

		myApartmentExpenses.printIndividualTransactions();
		System.out.println("Alternatively, we could use the following distribution:");
		myApartmentExpenses.printMinimumIndividualTransactions();
	}
}
