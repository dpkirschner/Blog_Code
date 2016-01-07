package com.kirscd.algorithms.rangeHolder;

import java.util.SortedSet;
import java.util.TreeSet;

public class RangeCondensorTree {
	private Node head;
	
	
	public RangeCondensorTree() {
		head = null;
	}
	
	public boolean contains(int value) {
		return findClosestNode(head, new Range(value, value)) != null;
	}

    public void add(Range range) {
    	//no head
    	if(head == null) {
    		Node node = new Node(range);
    		head = node;
    		return;
    	}

    	insertNodeWithNoOverlap(head, range);
    }
    
    private void insert(Range range) {
    	//guaranteed that head will not be null at this point so node will never be null
    	
    	Node node = findClosestNode(head, range);
    	assert(node != null);
    	
    	
    	if(node.range.compareTo(range) != 0) {
    		Node child = new Node(range);
    		if (node.range.compareTo(range) < 0) {
    			node.rightChild = child;
    		} else {
    			node.leftChild = child;
    		}
    		return;
    	} 
  	
 //if the left side expands during merge
 	//every node that is encircled disappears.
 	//first node that is overlapped, but not encircled, gets merged.
 	//that nodes right children go away and that nodes left child becomes parents right child.
 //if the right side expands during merge
 	//every node that is encircles disappears
 	//first node that is overlapped, but not encircled, gets merged.
	//that nodes left children go away and that nodes right child becomes parents left child.
 
   /* 	
    	
    	if(nodeRange.getLowerBound() > range.getLowerBound()) {
    		//expanding left side
    		
    		//find leftmost mergePoint where range.getLowerBound() is in node.range
    		//hook its parent.rightChild to leftChild
    		//node.leftChild = parent
    		//merge the original range and the nodes range
    		
    		
    		//what happens if it never overlaps, but does encircle?
    		//what happens if it doesn't encircle or overlap?
    		
    	}
    	
    	if(nodeRange.getUpperBound() < range.getUpperBound()) {
    		//expanding right side
    	}
 */
    }
    
    private void insertNodeWithNoOverlap(Node current, Range range) {
    	if(current.range.compareTo(range) < 0) {
    		//this node is less than range we want
    		if(current.rightChild == null) {
    			Node node = new Node(range);
    			current.rightChild = node;
    			return;
    		} else {
    			insertNodeWithNoOverlap(current.rightChild, range);
    		}
    	} else if (current.range.compareTo(range) > 0) { 
    		//this node is more than the range we want
    		if(current.leftChild == null) {
    			Node node = new Node(range);
    			current.leftChild = node;
    			return;
    		} else {
    			insertNodeWithNoOverlap(current.leftChild, range);
    		}
    	}

    	//we have overlap or succession
    	insertWithOverlap(current, current, range);
    }
    
    private void insertWithOverlap(Node toMerge, Node current, Range range) {
    	if(current.range.getUpperBound() < range.getUpperBound()) {
    		//we need to merge Right
    	}
    	if(current.range.getLowerBound() > range.getLowerBound()) {
    		//we need to merge Left
    		insertWithOverlap(toMerge, current.leftChild, range);
    	}
    }
    
    private Node findClosestNode(Node current, Range range) {
    	if(current == null) {
    		return null;
    	}

    	if(current.range.compareTo(range) < 0) {
    		return findClosestNode(current.rightChild, range); //this node is less than range we want
    	} else if (current.range.compareTo(range) > 0) {
    		return findClosestNode(current.leftChild, range); //this node is more than the range we want
    	}
    	
    	return current; //matching node
    }
    
    public static void main(String args[]) {
    	RangeCondensorTree ranger = new RangeCondensorTree();
    	System.out.println("Ranger contains 1: " + ranger.contains(1));
    	ranger.add(new Range(0, 10));
    	System.out.println("Ranger contains 1: " + ranger.contains(1));
    	System.out.println("Ranger contains -1: " + ranger.contains(-1));
    	System.out.println("Ranger contains 10: " + ranger.contains(10));
    	System.out.println("Ranger contains 11: " + ranger.contains(11));
    	ranger.add(new Range(11, 45));
    	System.out.println("Ranger contains 11: " + ranger.contains(11));
    	ranger.add(new Range(-10, -1));
    	System.out.println("Ranger contains -1: " + ranger.contains(-1));
    }

    private class Node {
    	public Node leftChild;
    	public Node rightChild;
    	public Range range;
    	
    	public Node(Range range) {
    		this.range = range;
    	}
    }
}
