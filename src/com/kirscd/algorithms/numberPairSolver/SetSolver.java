package com.kirscd.algorithms.numberPairSolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetSolver extends NumberPairSolver{
	//O(n) because you are touching every element (technically touching twice but lets not split hairs)
	public boolean solve(ArrayList<Integer> numbers, int target) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < numbers.size(); i++) {
			set.add(numbers.get(i));
		}
		
		for(int i = 0; i < numbers.size(); i++) {
			if(set.contains(target - numbers.get(i))) {
				return true;
			}
		}
		return false;
	}
}
