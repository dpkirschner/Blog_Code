package com.kirscd.cake;

import com.kirscd.cake.context.AppContext;
import com.kirscd.cake.context.ProdContext;

public class Solid {

	public static void main(String[] args) {
		AppContext ctx = Memoizer.memoize(new ProdContext() {});
		System.out.println(ctx.foo());
		System.out.println(ctx.bar());
		System.out.println(ctx.foobar());
	}

}
