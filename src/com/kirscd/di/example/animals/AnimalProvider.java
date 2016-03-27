package com.kirscd.di.example.animals;

import com.kirscd.di.example.loggers.LogProvider;

public interface AnimalProvider extends LogProvider {
	String getAnimal();
}
