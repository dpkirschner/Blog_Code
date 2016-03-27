package com.kirscd.cake.proxies;

import java.lang.reflect.Proxy;

public class ProxyFactory {
	public static Object getProxy(Object obj, Class<?>[] interfaces) {
		
		Object proxy = Proxy.newProxyInstance(
				obj.getClass().getClassLoader()
				, interfaces
				, new MethodLogger(obj));
		return proxy;
	}
}
