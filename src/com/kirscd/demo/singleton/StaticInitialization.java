package com.kirscd.demo.singleton;


/**
 * Static initialization means that the constructor is guaranteed to only execute once.
 *
 */
public class StaticInitialization {
	private static StaticInitialization instance = new StaticInitialization();
	
	private StaticInitialization(){
		System.out.println("inside StaticInitialization constructor");
	}
	
	public static StaticInitialization getInstance() {
		System.out.println("returning StaticInitialization instance");
		return instance;
	}
}
