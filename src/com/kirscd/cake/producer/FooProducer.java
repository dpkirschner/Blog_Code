package com.kirscd.cake.producer;

import com.kirscd.cake.provider.FooProvider;
import com.kirscd.cake.provider.MethodLogProvider;

public interface FooProducer extends FooProvider, MethodLogProvider {
    @Override default String foo() {
        methodLog().accept("foo");
        return "FOO";
    }
}
