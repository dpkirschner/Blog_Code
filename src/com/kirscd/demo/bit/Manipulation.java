package com.kirscd.demo.bit;

public class Manipulation {
	public static void main(String args[]) {
		int a = 0x3;
		int b = 0x5;
		
		println4(a);
		println4(b);
		println4(~a);
		println4(~b);
		println4(a & b);
		println4(a ^ b);
		println4(a | b);
	}
	
	private static void println4(int n) {
		for(int i=3; i>=0; i--) {
			System.out.print(n >> i & 1);
		}
		System.out.println();
	}
}
