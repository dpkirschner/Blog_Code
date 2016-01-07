package com.kirscd.algorithms.rangeHolder;

public class Range implements Comparable<Range> {
	private int lowerBound;
	private int upperBound;
	
	Range(int lowerBound, int upperBound) {
		assert(lowerBound <= upperBound);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	public int getLowerBound() {
		return lowerBound;
	}
	
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	public int getUpperBound() {
		return upperBound;
	}
	
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	
	public void merge(Range range) {
		this.lowerBound = Math.min(this.lowerBound, range.getLowerBound());
		this.upperBound = Math.min(this.upperBound, range.getUpperBound());
	}

	@Override
	public int compareTo(Range range) {
		if(this.upperBound < range.lowerBound) {
			return -1;
		} else if(this.lowerBound > range.upperBound) {
			return 1;
		}
		return 0;
	}
}
