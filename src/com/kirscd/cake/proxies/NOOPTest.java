package com.kirscd.cake.proxies;

import java.util.ArrayList;
import java.util.List;

public class NOOPTest {
	public static void main(String args[]) {
		ArrayList<Integer> mine = new ArrayList<Integer>();
		
		//getClass().getInterfaces() will only return classes that are directly implemented by
		//the original object. It will not return any indirect interfaces.
		@SuppressWarnings("unchecked")
		List<Integer> proxy = (List<Integer>)ProxyFactory.getProxy(mine, mine.getClass().getInterfaces());
		
		proxy.add(0);
		proxy.add(15);

		printInts(proxy);
	}

	private static void printInts(List<Integer> mine) {
		mine.forEach(min -> System.out.print(min+","));
		System.out.println();
	}
}
