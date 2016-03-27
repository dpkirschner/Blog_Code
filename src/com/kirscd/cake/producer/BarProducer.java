package com.kirscd.cake.producer;

import com.kirscd.cake.provider.BarProvider;
import com.kirscd.cake.provider.MethodLogProvider;

public interface BarProducer extends BarProvider, MethodLogProvider {
    @Override default String bar() {
        methodLog().accept("bar");
        return "BAR";
    }
}