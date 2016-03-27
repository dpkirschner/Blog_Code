package com.kirscd.di.example.animals;

public interface MooseAnimalProducer extends AnimalProvider {
	@Override
	default String getAnimal() {
		logger().accept("getAnimal");
		return "Moose";
	}
}
