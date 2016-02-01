package com.kirscd.algorithms.graph;

import java.util.ArrayList;

/**
 * Node class for each letter.
 * In order to make this problem easier I've specifically added two lists of edges,
 * one for incoming edges and one for outgoing. This will make other types of graph
 * transformation more difficult.
 */
public class Node {
	//Nodes that connect to this node
	public ArrayList<Node> inEdges;
	//Nodes that this node connects to
	public ArrayList<Node> outEdges;
	public Character name;
	
	public Node(Character name) {
		this.name = name;
		this.inEdges = new ArrayList<Node>();
		this.outEdges = new ArrayList<Node>();
	}
	
	@Override
	public String toString() {
		return "node: " + this.name;
	}
}
