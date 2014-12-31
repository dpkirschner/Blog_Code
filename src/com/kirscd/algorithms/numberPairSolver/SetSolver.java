package com.kirscd.algorithms.numberPairSolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetSolver extends NumberPairSolver{
	Set<Integer> set = null;
	
	//O(n) for initial run, O(1) for subsequent runs
	public boolean solve(ArrayList<Integer> numbers, int target) {
		//to keep the example simple I will not be clearing the set for different array inputs, but that is an edge case
		//that should be covered if this was to see actual use
		if(set == null) {
			set = new HashSet<Integer>();
			for(int i = 0; i < numbers.size(); i++) {
				set.add(numbers.get(i));
			}
		}

		for(int i = 0; i < numbers.size(); i++) {
			if(set.contains(target - numbers.get(i))) {
				return true;
			}
		}
		return false;
	}
}
