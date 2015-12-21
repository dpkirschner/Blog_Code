package com.kirscd.demo.cycles;

import java.util.HashSet;
import java.util.Set;

public class Classic {

	public static boolean withSet(Node head) {
		Set<Node> seenNodes = new HashSet<Node>();
		Node current = head;
		while(current != null) {
			if(seenNodes.contains(current)) {
				return true;
			}
			seenNodes.add(current);
			current = current.getNext();
		}
		return false;
	}
	
	public static void main(String args[]) {
		Node withoutCycle = Node.buildTestChain(false);
		try {
			System.out.println("WithoutCycle has a cycle: " + withSet(withoutCycle));
			System.out.println("To prove that lets print the list.");
			Node.printList(withoutCycle);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Node withCycle = Node.buildTestChain(true);
		try {
			System.out.println("WithCycle has a cycle: " + withSet(withCycle));
			System.out.println("To prove that lets print the list.");
			Node.printList(withCycle);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
