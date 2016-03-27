package com.kirscd.cake.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodLogger implements InvocationHandler {

	private final Object proxied;

	public MethodLogger(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(String.format("called '%s' against '%s'", method.getName(), proxied.getClass()));
		return method.invoke(proxied, args);
	}
}