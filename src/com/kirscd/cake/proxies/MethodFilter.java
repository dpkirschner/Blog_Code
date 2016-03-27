package com.kirscd.cake.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodFilter implements InvocationHandler{

	private final Object proxied;

	public MethodFilter(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().startsWith("add")) {
			System.out.println(String.format("rejected method call '%s' against '%s'", method.getName(), proxied.getClass()));
			return false;
		}
		
		return method.invoke(proxied, args);
	}
}
