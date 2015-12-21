package com.kirscd.demo.cycles;

import java.util.stream.IntStream;

public class Node {
	private Node next;
	private int value;
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public static Node buildTestChain(boolean shouldCycle) {
		Node head = new Node(0);
		Node previous = head;
		Node current = null;
		for(int i = 1; i<10; i++) {
			current = new Node(i);
			previous.next = current;
			previous = current;
		}
		
		if(shouldCycle) {
			current.next = head;
		}
		
		return head;
	}
	
	public static void printList(Node node) throws Exception {
		int i = 0;
		Node current = node;
		while(current != null) {
			System.out.print(current.value + " -> ");
			current = current.next;
			i++;
			if(i > 20) {
				System.out.println();
				throw new Exception("List may have a cycle. "
						+ "Throwing exception to prevent infinite recursion while printing");
			}
		}
	}
}
