package com.kirscd.di.simple;

public class ZooWithoutDI {
	private Animal animal;
	
	public ZooWithoutDI() {
		this.animal = new Animal("lion");
	}
	
	public void printAnimals() {
		System.out.println(String.format("I have an %s!", animal.name));
	}
}
