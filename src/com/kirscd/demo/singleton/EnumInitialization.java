package com.kirscd.demo.singleton;

public enum EnumInitialization {
	INSTANCE;
	
	private EnumInitialization() {
		System.out.println("inside EnumInitialization constructor");
	}
	
	public void getInstance() {
		System.out.println("getting EnumInitialization instance");
	}
}
