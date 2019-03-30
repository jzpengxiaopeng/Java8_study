package com.jzpengxiaopeng.java8.inter;

public interface MyInterface2 {
	default String getValue() {
		return MyInterface2.class.getName();
	}
}
