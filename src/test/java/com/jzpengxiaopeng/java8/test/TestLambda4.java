package com.jzpengxiaopeng.java8.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.jzpengxiaopeng.java8.entity.Employee;
import com.jzpengxiaopeng.java8.function.MyFunction;
import com.jzpengxiaopeng.java8.function.MyFunction2;

public class TestLambda4 {
	List<Employee> employees = Arrays.asList(new Employee("关羽", 55, 55000), new Employee("张飞", 45, 50000),
			new Employee("马超", 40, 45000), new Employee("黄忠", 65, 45000), new Employee("赵云", 35, 3000));

	@Test
	public void test1() {
		Collections.sort(employees, (e1, e2) -> {
			if (e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			} else {
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});

		employees.forEach((e) -> System.out.println(e));
	}

	@Test
	public void test2() {
		String str = getValue("WoAiBeiJingTianAnMen", (x) -> x.toUpperCase());
		System.out.println("str: " + str);

		String str2 = getValue("WoAiBeiJingTianAnMen", (x) -> x.substring(4, 11));
		System.out.println("str2: " + str2);
	}

	private String getValue(String s, MyFunction<String, String> func) {
		return func.getValue(s);
	}

	@Test
	public void test3() {
		Long l1 = getValue(100L, 200L, (x, y) -> x * y);
		System.out.println(l1);

		Long l2 = getValue(100L, 200L, (x, y) -> x + y);
		System.out.println(l2);
	}

	private Long getValue(Long l1, Long l2, MyFunction2<Long, Long> func) {
		return func.getValue(l1, l1);
	}

}
