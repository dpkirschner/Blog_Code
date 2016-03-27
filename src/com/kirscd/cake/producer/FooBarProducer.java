package com.kirscd.cake.producer;

import com.kirscd.cake.provider.BarProvider;
import com.kirscd.cake.provider.FooBarProvider;
import com.kirscd.cake.provider.FooProvider;
import com.kirscd.cake.provider.MethodLogProvider;

public interface FooBarProducer extends FooBarProvider, FooProvider, BarProvider, MethodLogProvider {
    @Override default String foobar() {
        methodLog().accept("foobar");
        return foo() + bar();
    }
}
