package com.kirscd.di.example.loggers;

import java.util.function.Consumer;

public interface LogProvider {
	Consumer<String> logger();
}
