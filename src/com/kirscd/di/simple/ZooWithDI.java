package com.kirscd.di.simple;

public class ZooWithDI {
	private Animal animal;
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public void printAnimals() {
		System.out.println(String.format("I have an %s!", animal.name));
	}
}
