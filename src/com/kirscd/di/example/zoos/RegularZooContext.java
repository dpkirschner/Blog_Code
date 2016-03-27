package com.kirscd.di.example.zoos;

import com.kirscd.di.example.animals.MooseAnimalProducer;
import com.kirscd.di.example.colors.WhiteColorProducer;
import com.kirscd.di.example.loggers.MethodLogProducer;

public class RegularZooContext implements ZooContext, MooseAnimalProducer, WhiteColorProducer, MethodLogProducer {

}
