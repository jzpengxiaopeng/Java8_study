package com.jzpengxiaopeng.java8.function;

@FunctionalInterface
public interface MyFunction<T, R> {
	R getValue(T t);
}
