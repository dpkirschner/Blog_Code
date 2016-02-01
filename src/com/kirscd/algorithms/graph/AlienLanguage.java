package com.kirscd.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Imagine you receive a message from aliens. They use the 26 English letters as the basis 
 * for their alphabet, but the ordering is quite different. 
 * Given a small sampling of a dictionary from their home planet, 
 * return one possible alphabet ordering. More succinctly, 
 * given an array of words sorted by some sequence, 
 * return a possible ordering for the letters.
 * For example [‘ccda’, ‘ccbk’, ‘cd’, ‘a’, ‘ab’] could have many orderings, 
 * but one is “c, a, d, b, k”. Another is “k, c, d, b, a”.
 *
 */
public class AlienLanguage {
	
	/**
	 * Use Kahn's algorithm to topologically sort the nodes in the graph into one 
	 * possible ordering. The exact ordering will depend on the order of the nodes it gets
	 * from the collection passed in and may change.
	 * 
	 * See @blogpost for an explanation of how this works.
	 * @param values a collection of nodes to sort
	 * @return
	 */
	private static List<Node> topologicalSort(Collection<Node> nodes) {
		//nodes which have no incoming edges and can be placed directly into the final sorted list
		Queue<Node> noIncomingEdges = findEmptyIncomingEdges(nodes);
		//will hold our final sorted nodes
		List<Node> topSortedNodes = new LinkedList<Node>();
		
		while(!noIncomingEdges.isEmpty()) {
			Node node = noIncomingEdges.remove();
			//for every node this node touches
			for(Node neighbor : node.outEdges) {
				//remove the relationship that we built
				neighbor.inEdges.remove(node);
				//if this neighbor now has no nodes that must come before it
				if(neighbor.inEdges.isEmpty()) {
					//add it to our queue of nodes ready to be placed in the sorted list
					noIncomingEdges.add(neighbor);
				}
			}
			//each node here started with no incoming edges, and will leave with no outgoing edges
			node.outEdges.clear();
			//add this node to the sorted list.
			topSortedNodes.add(node);
		}
		
		//Ensure that we have considered every node possible.
		for(Node node : nodes) {
			if(!node.inEdges.isEmpty()) {
				throw new IllegalArgumentException("There was a cycle in the graph. No topological sort is possible.");
			}
		}
		
		return topSortedNodes;
	}

	/**
	 * Returns a queue of nodes that have no incoming edges. Remember outgoing edges mean this node
	 * comes before that one, while incoming edges mean that node comes before this one. Since
	 * these nodes have no incoming edges, they will be at the beginning of our topological 
	 * sorted nodes.
	 * @param nodes
	 * @return
	 */
	private static Queue<Node> findEmptyIncomingEdges(Collection<Node> nodes) {
		Queue<Node> emptyIncomingNodes = new ArrayDeque<Node>();
		
		for(Node node : nodes) {
			if(node.inEdges.size() == 0) {
				emptyIncomingNodes.add(node);
			}
		}
		
		return emptyIncomingNodes;
	}

	/**
	 * Given a list that contains the topological sorted nodes, construct a string
	 * of their names
	 * @param topSorted
	 * @return
	 */
	private static String constructString(List<Node> topSorted) {
		StringBuilder sb = new StringBuilder();
		for(Node node : topSorted) {
			sb.append(node.name + " -> ");
		}
		return sb.toString();
	}
	
	public static void main(String args[]) {
		String[] words = {"ccda", "ccbk", "cd", "a", "ab"};
		Collection<Node> nodes = AlienLanguageGraph.generate(words);
		List<Node> topSorted = topologicalSort(nodes);
		
		System.out.println("top sort");
		System.out.println(constructString(topSorted));
	}
}
