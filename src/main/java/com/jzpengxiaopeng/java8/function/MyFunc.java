package com.jzpengxiaopeng.java8.function;

@FunctionalInterface
public interface MyFunc<T> {
	T getValue(T t);
}
