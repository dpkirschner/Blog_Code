package com.kirscd.di.example;

import com.kirscd.di.example.zoos.RegularZooContext;
import com.kirscd.di.example.zoos.SyFyZooContext;
import com.kirscd.di.example.zoos.ZooContext;

public class Zoo {
	public static void main(String args[]) {
		ZooContext sifi = new SyFyZooContext();
		System.out.format("Our zoo has a %s that is %s!%n", sifi.getAnimal(), sifi.getColor());
		ZooContext regular = new RegularZooContext();
		System.out.format("Our zoo has a %s that is %s!%n", regular.getAnimal(), regular.getColor());
	}
}
