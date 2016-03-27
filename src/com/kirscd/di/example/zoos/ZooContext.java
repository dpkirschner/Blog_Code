package com.kirscd.di.example.zoos;

import com.kirscd.di.example.animals.AnimalProvider;
import com.kirscd.di.example.colors.ColorProvider;
import com.kirscd.di.example.loggers.LogProvider;

public interface ZooContext extends ColorProvider, AnimalProvider, LogProvider {

}
