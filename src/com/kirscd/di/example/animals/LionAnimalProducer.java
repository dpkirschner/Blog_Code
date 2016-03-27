package com.kirscd.di.example.animals;

public interface LionAnimalProducer extends AnimalProvider {
	@Override
	default String getAnimal() {
		logger().accept("getAnimal");
		return "Lion";
	}
}
