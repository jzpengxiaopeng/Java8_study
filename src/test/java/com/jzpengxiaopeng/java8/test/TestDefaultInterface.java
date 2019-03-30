package com.jzpengxiaopeng.java8.test;

import org.junit.Test;

import com.jzpengxiaopeng.java8.inter.MyInterface1;
import com.jzpengxiaopeng.java8.myClazz.SubClass;

public class TestDefaultInterface {
	
	@Test
	public void test1() {
		SubClass sc = new SubClass();
		System.out.println(sc.getValue());
		
		MyInterface1.staticMethod();
	}
	
}
