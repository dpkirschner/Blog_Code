package com.kirscd.demo.singleton;

/**
 * This is may/not fail in a multi threaded environment.
 * What would happen if two threads called getInstance at the same time? They would
 * both see that the variable is null, and both try to instantiate it. This could cause
 * conflicts where each thread thinks that they have a reference to the "correct" instance
 */
public final class LazyInitialization {
	private static LazyInitialization instance;
	
	private LazyInitialization(){
		System.out.println("inside LazyInitialization constructor");
	}
	
	public final static LazyInitialization getInstance() {
		System.out.println("getting LazyInitialization instance");
		if(instance == null) {
			instance = new LazyInitialization();
		}
		return instance;
	}
}
