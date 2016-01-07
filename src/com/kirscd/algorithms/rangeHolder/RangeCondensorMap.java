package com.kirscd.algorithms.rangeHolder;

import java.util.SortedMap;
import java.util.TreeMap;

public class RangeCondensorMap {
	private SortedMap<Range, Range> map;
	
	public RangeCondensorMap() {
		map = new TreeMap<Range, Range>();
	}
	
	public boolean contains(int value) {
		return map.containsKey(new Range(value, value));
	}

    public void add(Range range) {
		//no matching ranges exist
    	Range existingRange = map.get(range);
    	if(existingRange == null) {
    		map.put(range, range);
    		return;
    	}
    	
		existingRange.merge(range);
    }
    
    public static void main(String args[]) {
    	RangeCondensorMap ranger = new RangeCondensorMap();
    	System.out.println("Ranger contains 1: " + ranger.contains(1));
    	ranger.add(new Range(0, 10));
    	System.out.println("Ranger contains 1: " + ranger.contains(1));
    	System.out.println("Ranger contains -1: " + ranger.contains(-1));
    	System.out.println("Ranger contains 10: " + ranger.contains(10));
    	System.out.println("Ranger contains 11: " + ranger.contains(11));
    	ranger.add(new Range(11, 45));
    	System.out.println("Ranger contains 11: " + ranger.contains(11));
    }
}
