package com.kirscd.cake.context;

import com.kirscd.cake.producer.BarProducer;
import com.kirscd.cake.producer.FooProducer;
import com.kirscd.cake.producer.MethodLogProducer;
import com.kirscd.cake.producer.TestFooBarProducer;

public class TestContext implements AppContext, FooProducer, BarProducer, TestFooBarProducer, MethodLogProducer {
	
	
}