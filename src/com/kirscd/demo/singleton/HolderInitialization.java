package com.kirscd.demo.singleton;

public class HolderInitialization {
	private static class HolderInitializationHolder {
		public static HolderInitialization holderLazyInit = new HolderInitialization();
	}
	
	public static HolderInitialization getInstance() {
		System.out.println("getting HolderInitialization instance");
		return HolderInitializationHolder.holderLazyInit;
	}
	
	private HolderInitialization(){
		System.out.println("Inside HolderInitialization construction");
	}
}
