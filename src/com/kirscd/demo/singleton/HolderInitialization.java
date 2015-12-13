package com.kirscd.demo.singleton;

public final class HolderInitialization {
	private final static class HolderInitializationHolder {
		public static HolderInitialization holderLazyInit = new HolderInitialization();
	}
	
	public final static HolderInitialization getInstance() {
		System.out.println("getting HolderInitialization instance");
		return HolderInitializationHolder.holderLazyInit;
	}
	
	private HolderInitialization(){
		System.out.println("Inside HolderInitialization construction");
	}
}
