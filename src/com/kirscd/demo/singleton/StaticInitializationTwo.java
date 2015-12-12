package com.kirscd.demo.singleton;

/**
 * An alternate way of doing static in initialization, specifically useful if
 * your initialization requires multiple lines of setup. EG: reading from a config file
 * or finding/creating subcomponents.
 */
public class StaticInitializationTwo {
	private static StaticInitializationTwo instance;
	static {
		instance = new StaticInitializationTwo();
	}
	
	private StaticInitializationTwo(){
		System.out.println("inside StaticInitialization constructor");
	}
	
	public StaticInitializationTwo getInstance() {
		System.out.println("returning StaticInitialization instance");
		return instance;
	}
}
