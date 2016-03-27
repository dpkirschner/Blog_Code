package com.kirscd.cake.context;

import com.kirscd.cake.producer.BarProducer;
import com.kirscd.cake.producer.FooBarProducer;
import com.kirscd.cake.producer.FooProducer;
import com.kirscd.cake.producer.MethodLogProducer;

public class ProdContext implements AppContext, FooProducer, BarProducer, FooBarProducer, MethodLogProducer {
	
	
}