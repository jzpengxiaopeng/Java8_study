package com.jzpengxiaopeng.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Test;

import com.jzpengxiaopeng.java8.entity.Employee;

/*
 * 一、Stream API 的操作步骤：
 * 
 * 1. 创建 Stream
 * 
 * 2. 中间操作
 * 
 * 3. 终止操作(终端操作)
 */
public class TestStreamAPI {

	List<Employee> employees = Arrays.asList(new Employee("关羽", 55, 55000), new Employee("张飞", 45, 50000),
			new Employee("马超", 40, 45000), new Employee("黄忠", 65, 45000), new Employee("黄忠", 65, 45000),
			new Employee("黄忠", 65, 45000), new Employee("黄忠", 65, 45000), new Employee("黄忠", 65, 45000),
			new Employee("赵云", 35, 3000));

	@Test
	public void test1() {
		// 1.
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();
		Stream<String> parallelStream = list.parallelStream();

		// 2.
		Integer[] array = new Integer[10];
		Stream<Integer> stream2 = Arrays.stream(array);

		// 3.
		Stream<Integer> stream3 = Stream.of(1, 2, 3);

		// 4.1
		Stream.iterate(0, (x) -> x + 2).limit(10).forEach(System.out::println);

		// 4.2
		Stream<Double> stream4 = Stream.generate(Math::random);
		stream4.limit(5).forEach(System.out::println);
	}

	@Test
	public void test2() {
		Stream<Employee> stream = employees.stream().filter((e) -> {
			System.out.println("惰性求值");
			return e.getAge() > 45;
		});
		stream.forEach(System.out::println);
	}

	@Test
	public void test3() {
		employees.stream().filter((e) -> {
			System.out.println("短路");
			return e.getSalary() > 5000;
		}).limit(2).forEach(System.out::println);
	}

	@Test
	public void test4() {
		employees.stream().filter((e) -> e.getSalary() > 5000).skip(2).distinct().forEach(System.out::println);
	}

	@Test
	public void test5() {
		List<String> list = Arrays.asList("aaa", "bbb", "ccc", "dddd");
		list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);

		System.out.println("----------------------------------");

		// employees.stream().map((e) -> e.getName()).forEach(System.out::println);
		employees.stream().map(Employee::getName).forEach(System.out::println);

		System.out.println("----------------------------------");

		Stream<Stream<Character>> stream = list.stream().map(TestStreamAPI::map);
		stream.forEach(sm -> sm.forEach(System.out::println));

		System.out.println("----------------------------------");

		Stream<Character> stream2 = list.stream().flatMap(TestStreamAPI::map);
		stream2.forEach(System.out::println);

	}

	private static Stream<Character> map(String str) {
		List<Character> list = new ArrayList<>();

		for (Character c : str.toCharArray()) {
			list.add(c);
		}

		return list.stream();
	}

	@Test
	public void test6() {
		List<String> list = Arrays.asList("bbb", "ccc", "aaa", "333");
		list.stream().sorted().forEach(System.out::println);

		System.out.println("----------------------------------");

		employees.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).forEach(System.out::println);

	}

}
