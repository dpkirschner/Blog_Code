package com.kirscd.cake.context;

import com.kirscd.cake.provider.BarProvider;
import com.kirscd.cake.provider.FooBarProvider;
import com.kirscd.cake.provider.FooProvider;

public interface AppContext extends FooBarProvider, FooProvider, BarProvider {

}
