package com.kirscd.cake;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Memoizer {

	/**
     * Wraps an object with a dynamic proxy that intercepts method calls,
     * caching the return values and preventing any method from being invoked more than once.
     * Though the return value cache is thread-safe,
     * the thread safety contract of the wrapped object's methods is unchanged.
     * 
     * @param object An object.
     * All methods that are not inherited from {@link Object} must have 0 arguments
     * and be implemented as {@code default} methods.
     * @return A proxy that implements all the same interfaces as the input object,
     * and memoizes all methods not inherited from {@link Object}.
     */
    @SuppressWarnings("unchecked")
    static <T> T memoize(T object) {
        for (Method method : object.getClass().getMethods()) {
            if (method.getDeclaringClass() != Object.class
                    && (!method.getDeclaringClass().isInterface() || method.getParameters().length > 0)) {
                throw new IllegalArgumentException("Invalid method: " + method);
            }
        }
 
        Map<Method, Object> cache = new ConcurrentHashMap<>();
 
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if (method.getDeclaringClass() == Object.class) {
                        return method.invoke(cache, args);
                    }
 
                    synchronized (method) {
                        if (cache.containsKey(method)) {
                            return cache.get(method);
                        }
 
                        final Object result = MethodHandles.lookup()
                                .in(method.getDeclaringClass())
                                .unreflectSpecial(method, method.getDeclaringClass())
                                .invoke(proxy);
                        cache.put(method, result);
                        return result;
                    }
                });
    }
}
