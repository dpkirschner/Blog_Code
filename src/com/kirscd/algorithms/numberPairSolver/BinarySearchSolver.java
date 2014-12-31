package com.kirscd.algorithms.numberPairSolver;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchSolver extends NumberPairSolver{
    //O(n * log n) because you are sorting and then doing binary search on result
    public boolean solve(ArrayList<Integer> numbers, int target) {
        Collections.sort(numbers);
        
        for(int i = 0; i < numbers.size(); i++) {
            int difference = target - numbers.get(i);
            int start = 0;
            int end = numbers.size() - 1;
            while (start <= end) {
                int middle = start + (end - start) / 2;
                if      (difference < numbers.get(middle)) end = middle - 1;
                else if (difference > numbers.get(middle)) start = middle + 1;
                else return true;
            }
        }
        
        return false;
    }
}
