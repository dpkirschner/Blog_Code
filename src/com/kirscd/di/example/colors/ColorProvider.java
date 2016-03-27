package com.kirscd.di.example.colors;

import com.kirscd.di.example.loggers.LogProvider;

public interface ColorProvider extends LogProvider {
	String getColor();
}
