package com.jzpengxiaopeng.java8.function;

@FunctionalInterface
public interface MyFunction2<T, R> {
	R getValue(T t1, T t2);
}
