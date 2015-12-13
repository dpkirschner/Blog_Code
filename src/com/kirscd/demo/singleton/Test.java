package com.kirscd.demo.singleton;

import java.util.stream.IntStream;

public class Test {

	public static void main(String args[]) {
		System.out.println("LazyInitialization testing.......");
		IntStream.range(0,3).forEach(n -> {
			LazyInitialization.getInstance();
		});
		System.out.println();
		System.out.println("StaticInitialization testing.......");
		IntStream.range(0,3).forEach(n -> {
			StaticInitialization.getInstance();
		});
		System.out.println();
		System.out.println("HolderInitialization testing.......");
		IntStream.range(0,3).forEach(n -> {
			HolderInitialization.getInstance();
		});
		System.out.println();
		System.out.println("EnumInitialization testing.......");
		IntStream.range(0,3).forEach(n -> {
			EnumInitialization.INSTANCE.doWork();
		});
		
		
		
	}
}
