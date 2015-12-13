package com.kirscd.demo.singleton;


/**
 * Static initialization means that the constructor is guaranteed to only execute once.
 *
 */
public final class StaticInitialization {
	private final static StaticInitialization instance = new StaticInitialization();
	
	private StaticInitialization(){
		System.out.println("inside StaticInitialization constructor");
	}
	
	public final static StaticInitialization getInstance() {
		System.out.println("returning StaticInitialization instance");
		return instance;
	}
}
