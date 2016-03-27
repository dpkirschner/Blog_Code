package com.kirscd.di.example.colors;

public interface WhiteColorProducer extends ColorProvider {
	@Override
	default String getColor() {
		logger().accept("getColor");
		return "White";
	}
}