package com.jzpengxiaopeng.java8.test;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Test;

public class TestLambda5 {

	@Test
	public void test1() {
		Function<String, String> func = (s) -> s.toUpperCase();
		System.out.println(func.apply("WoAiBeiJingTianAnMen"));

		System.out.println("---------------------------------------");

		Function<String, String> func2 = String::new;
		System.out.println(func2.apply("TianAnMenShangTaiYangSheng"));

		System.out.println("---------------------------------------");

		Function<String, String> func3 = (s) -> s.concat(s);
		System.out.println(func3.apply("TianAnMenShangTaiYangSheng"));

		System.out.println("---------------------------------------");

		String s = "WoAiBeiJingTianAnMen ";
		Function<String, String> func4 = s::concat;
		System.out.println(func4.apply("TianAnMenShangTaiYangSheng"));
	}

	@Test
	public void test2() {
		BiFunction<Long, Long, Long> biFunc = (x, y) -> x * y;
		System.out.println(biFunc.apply(100L, 299L));

		System.out.println("---------------------------------------");

		BiFunction<Long, Long, Long> biFunc2 = Math::min;
		System.out.println(biFunc2.apply(100L, 299L));

		System.out.println("---------------------------------------");

		BiFunction<Long, Long, Long> biFunc3 = Long::divideUnsigned;
		System.out.println(biFunc3.apply(200L, 49L));
	}
}
