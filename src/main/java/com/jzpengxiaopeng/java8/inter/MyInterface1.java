package com.jzpengxiaopeng.java8.inter;

public interface MyInterface1 {
	default String getValue() {
		return MyInterface1.class.getName();
	}
	
	static void staticMethod() {
		System.out.println("static method in java8 interface");
	}
}
