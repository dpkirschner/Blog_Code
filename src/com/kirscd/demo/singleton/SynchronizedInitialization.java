package com.kirscd.demo.singleton;

public class SynchronizedInitialization {
	private static SynchronizedInitialization instance;
	
	private SynchronizedInitialization(){
		System.out.println("inside SynchronizedInitialization constructor");
	}
	
	public synchronized final static SynchronizedInitialization getInstance() {
		System.out.println("getting SynchronizedInitialization instance");
		if(instance == null) {
			instance = new SynchronizedInitialization();
		}
		return instance;
	}
}
