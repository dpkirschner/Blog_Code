package com.kirscd.cake.provider;

import java.util.function.Consumer;

public interface MethodLogProvider {
    Consumer<String> methodLog();
}