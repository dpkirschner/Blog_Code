package com.kirscd.di.example.colors;

public interface GreenColorProducer extends ColorProvider {
	@Override
	default String getColor() {
		logger().accept("getColor");
		return "Green";
	}
}