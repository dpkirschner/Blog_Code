package com.kirscd.demo.cycles;

public class Floyds {
	
	private static boolean recursive(Node head) {
		if(head == null || head.getNext() == null) {
			return false;
		}
		
		return recursiveHelper(head.getNext(), head.getNext().getNext());
	}
	
	private static boolean recursiveHelper(Node slow, Node fast) {
		if(slow == null || fast == null || fast.getNext() == null) {
			return false;
		}
		if(slow == fast) {
			return true;
		}
		
		return recursiveHelper(slow.getNext(), fast.getNext().getNext());
	}
	
	public boolean iterative(Node node) {
		if(node == null) {
			return false;
		}
		
		Node slow = node;
		Node fast = node;
		
		while(true) {
			if(fast == null || fast.getNext() == null) {
				return false;
			}
			if(slow == fast) {
				return true;
			}
			
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
	}
	
	public static void main(String args[]) {
		Node withoutCycle = Node.buildTestChain(false);
		try {
			System.out.println("WithoutCycle has a cycle: " + recursive(withoutCycle));
			System.out.println("To prove that lets print the list.");
			Node.printList(withoutCycle);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Node withCycle = Node.buildTestChain(true);
		try {
			System.out.println("WithCycle has a cycle: " + recursive(withCycle));
			System.out.println("To prove that lets print the list.");
			Node.printList(withCycle);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
