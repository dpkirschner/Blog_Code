package com.kirscd.algorithms.numberPairSolver;

import java.util.ArrayList;


public abstract class NumberPairSolver {

	//O(n) because you have 2 pointers moving at most a combined n spaces
	public abstract boolean solve(ArrayList<Integer> numbers, int target);

}