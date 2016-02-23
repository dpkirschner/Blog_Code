package com.kirscd.demo.expenses;

import java.util.HashMap;
import java.util.Map;

public class ApartmentCalculatorWithGraph {
	private Map<String, Node> nodes;
	
	public ApartmentCalculatorWithGraph() {
		nodes = new HashMap<String, Node>();
	}
	
	public void addTransaction(String fromName, String toName, Integer amount) {
		if(!nodes.containsKey(fromName)) {
			nodes.put(fromName, new Node(fromName));
		}
		if(!nodes.containsKey(toName)) {
			nodes.put(toName, new Node(toName));
		}
		
		nodes.get(fromName).borrow(nodes.get(toName), amount);
	}
	
	public void optimizeTransactions() {
		//for every 2nd order relationship, reduce to 2 or 1 1st order relationship
		
		//A owes 5 to B, B owes 12 to C
		//	A owes 5 to C, B owes 7 to C
		//A owes 5 to B, B owes 5 to C
		//	A owes 5 to C
		//A owes 12 to B, B owes 5 to C
		//	A owes 7 to B, A owes 5 to C
		
		
		boolean runAgain = true;
		while(runAgain) {
			runAgain = convertSecondOrder();
		}
	}
	
	private boolean convertSecondOrder() {
		boolean runAgain = false;
		
		for(Node node : nodes.values()) {
			for(Edge firstOrder : node.outEdges.values()) {
				Node neighbor = firstOrder.neighbor;
				for(Edge secondOrder : neighbor.outEdges.values()) {
					node.outEdges.remove(firstOrder.neighbor.name);
					neighbor.outEdges.remove(secondOrder.neighbor.name);
					
					if(firstOrder.amount < secondOrder.amount) {
						node.borrow(secondOrder.neighbor, firstOrder.amount);
						neighbor.borrow(secondOrder.neighbor, secondOrder.amount - firstOrder.amount);
					} else if (firstOrder.amount > secondOrder.amount) {
						node.borrow(firstOrder.neighbor, firstOrder.amount - secondOrder.amount);
						node.borrow(secondOrder.neighbor, secondOrder.amount);
					} else {
						node.borrow(secondOrder.neighbor, firstOrder.amount);
					}
					runAgain = true;
				}
			}
		}
		
		return runAgain;
	}

	public void printTotals() {
		boolean noTransactions = true;
		for(Node node : nodes.values()) {
			for(Edge edge : node.outEdges.values()) {
				noTransactions = false;
				System.out.println(String.format("%s needs to pay %d dollars to %s this month"
						, node.name
						, edge.amount
						, edge.neighbor.name));
			}
		}
		
		if(noTransactions) {
			System.out.println("No transactions are needed this month");
		}
	}
	
	public static class Node {
		//represents money OWED to someone
		public Map<String, Edge> outEdges;
		public String name;
		
		public Node(String name) {
			this.name = name;
			outEdges = new HashMap<String, Edge>();
		}
		
		public void borrow(Node that, Integer amount) {
			if(amount == 0) {
				throw new IllegalArgumentException("amount owed can not be zero");
			}

			//if this owes that money already, add it to the bill
			if(outEdges.containsKey(that.name)) {
				outEdges.get(that.name).amount += amount;
				return;
			}
			
			//if that doesn't owe this anything, this owes that the full amount
			if(!that.outEdges.containsKey(this.name)) {
				outEdges.put(that.name, new Edge(that, amount));
				return;
			}
			
			reconcileAmounts(that, amount);
		}

		/**
		 * Here we know the fact THAT node currently owes THIS node some money. Depending on the
		 * exact amounts owed, the direction of the edge may switch, or may cancel.
		 * @param that
		 * @param amount
		 */
		private void reconcileAmounts(Node that, Integer amount) {
			Edge thatToThis = that.outEdges.get(this.name);
			switch(thatToThis.amount.compareTo(amount)) {
				case 1:
					thatToThis.amount -= amount;
					break;
				case 0:
					that.outEdges.remove(this.name);
					break;
				case -1:
					this.outEdges.put(that.name, new Edge(that, amount - thatToThis.amount));
					that.outEdges.remove(this.name);
					break;
				default:
					throw new IllegalArgumentException(String.format("invalid input: %d", thatToThis.amount));
					
			}
		}

		@Override
		public String toString() {
			return "node: " + this.name;
		}
	}
	
	public static class Edge {
		public Node neighbor;
		public Integer amount;
		
		public Edge(Node neighbor, Integer amount) {
			this.neighbor = neighbor;
			this.amount = amount;
		}
	}
	
	public static void main(String args[]) {
		ApartmentCalculatorWithGraph myExpenses = new ApartmentCalculatorWithGraph();
		myExpenses.addTransaction("Daniel", "Robert", 10);
		myExpenses.addTransaction("Robert","David", 10);
		myExpenses.addTransaction("David","Daniel", 10);

		myExpenses.optimizeTransactions();
		myExpenses.printTotals();
		
		myExpenses = new ApartmentCalculatorWithGraph();
		myExpenses.addTransaction("Daniel", "David", 10);
		myExpenses.addTransaction("David","Robert", 10);
		myExpenses.addTransaction("Robert","Chris", 10);

		myExpenses.optimizeTransactions();
		myExpenses.printTotals();
	}
}
