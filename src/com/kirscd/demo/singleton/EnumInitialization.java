package com.kirscd.demo.singleton;

public enum EnumInitialization {
	INSTANCE;
	
	private EnumInitialization() {
		System.out.println("inside EnumInitialization constructor");
	}
	
	public void doWork() {
		System.out.println("getting EnumInitialization instance");
	}
}
