package com.kirscd.algorithms.numberPairSolver;

import java.util.ArrayList;
import java.util.Collections;

public class PointerJuggleSolver extends NumberPairSolver{
	//O(n) because you have 2 pointers moving at most a combined n spaces
	public boolean solve(ArrayList<Integer> numbers, int target) {
		Collections.sort(numbers);
		
		int i = 0;
		int j = numbers.size() - 1;
		while (i < j) {
			if (numbers.get(i) + numbers.get(j) > target)
				j--;
            else if (numbers.get(i) + numbers.get(j) < target)
            	i++;
            else return true;
		}
		
		return false;
	}
}
