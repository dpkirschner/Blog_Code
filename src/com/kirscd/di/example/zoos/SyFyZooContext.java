package com.kirscd.di.example.zoos;

import com.kirscd.di.example.animals.LionAnimalProducer;
import com.kirscd.di.example.colors.GreenColorProducer;
import com.kirscd.di.example.loggers.MethodLogProducer;

public class SyFyZooContext implements ZooContext, LionAnimalProducer, GreenColorProducer, MethodLogProducer {

}
