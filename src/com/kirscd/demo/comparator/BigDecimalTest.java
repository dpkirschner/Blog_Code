package com.kirscd.demo.comparator;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class BigDecimalTest {
	public static void main(String args[]) {
		BigDecimal one = new BigDecimal("1");
		BigDecimal onePointZero = new BigDecimal("1.0");
		
		System.out.println("one.equals(onePointZero) is: " + one.equals(onePointZero));
		System.out.println("one.compareTo(onePointZero) is: " + one.compareTo(onePointZero));
		
		System.out.println();
		SortedSet<BigDecimal> sortedSet = new TreeSet<BigDecimal>();
		sortedSet.add(one);
		//TreeSet uses compareTo when doing comparisons so it thinks it contains onePointZero
		System.out.println("sorted set contains one: " + sortedSet.contains(one));
		System.out.println("sorted set contains onePointZero: " + sortedSet.contains(onePointZero));
		
		System.out.println();
		Set<BigDecimal> set = new HashSet<BigDecimal>();
		set.add(one);
		//HashSet uses equals when doing comparisons so it does not think it contains onePointZero
		System.out.println("generic set contains one: " + set.contains(one));
		System.out.println("generic set contains onePointZero: " + set.contains(onePointZero));
	}
}
