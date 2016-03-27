package com.kirscd.di.example.loggers;

import java.util.function.Consumer;

public interface MethodLogProducer extends LogProvider {
	@Override
	default Consumer<String> logger() {
		//functional interface that has a single method called accept();
		Consumer<String> logger = msg -> System.out.format("(inside %s)", msg);
        logger.accept("methodLog");
        return logger;
	}
}
