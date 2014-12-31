package com.kirscd.algorithms.numberPairSolver;

import java.util.ArrayList;
import java.util.Collections;

public class PointerJuggleSolver extends NumberPairSolver{
	//O(n * log n) because you are sorting and then have 2 pointers moving at most n spots
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
