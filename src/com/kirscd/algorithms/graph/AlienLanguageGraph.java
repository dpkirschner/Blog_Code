package com.kirscd.algorithms.graph;

import java.util.Collection;
import java.util.HashMap;

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
public class AlienLanguageGraph {
	
	public static Collection<Node> generate(String[] words) {
		HashMap<Character, Node> nodes = new HashMap<Character, Node>();
		buildNodes(words, nodes);
		buildEdges(words, nodes);
		return nodes.values();
	}

	/**
	 * Construct all of the nodes needed and put them into a map for easy retrieval later
	 */
	private static void buildNodes(String[] words, HashMap<Character, Node> nodes) {
		for(String word : words) {
			for(int i = 0; i < word.length(); i++) {
				if(!nodes.containsKey(word.charAt(i))) {
					nodes.put(word.charAt(i), new Node(word.charAt(i)));
				}
			}
		}
	}
	
	/**
	 * Walk through the dictionary given and add relationship data as
	 * it is found.
	 */
	private static void buildEdges(String[] words, HashMap<Character, Node> nodes) {
		//we don't have any relationship data in this case
		if(words.length <= 1) {
			return;
		}
		
		String prev = words[0];
		for(int i = 1; i < words.length; i++) {
			String current = words[i];
			//for every character in these two words
			for(int j = 0; j < Math.min(prev.length(), current.length()); j++) {
				//if the two characters don't match
				if(prev.charAt(j) != current.charAt(j)) {
					//add an outgoing edge from the letter node in prev to the letter node in current
					nodes.get(prev.charAt(j)).outEdges.add(nodes.get(current.charAt(j)));
					//add an incoming edge from the letter node in current to the letter node in prev
					nodes.get(current.charAt(j)).inEdges.add(nodes.get(prev.charAt(j)));
					break;
				}
			}
			prev = current;
		}
	}
}
