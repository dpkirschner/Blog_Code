package com.kirscd.cake.producer;

import java.util.function.Consumer;

import com.kirscd.cake.provider.MethodLogProvider;

public interface MethodLogProducer extends MethodLogProvider {
    @Override default Consumer<String> methodLog() {
        Consumer<String> logger = msg -> System.out.format("(called %s)", msg);
        logger.accept("methodLogger");
        return logger;
    }
}