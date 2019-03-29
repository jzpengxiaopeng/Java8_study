package com.jzpengxiaopeng.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/*
 * Java8 内置的四大核心函数式接口
 * 
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 * 
 * Supplier<T> : 供给型接口
 * 		T get(); 
 * 
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 * 
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 * 
 */
public class TestLambda3 {

	@Test
	public void test1() {
		happy("消费内容", s -> System.out.println("消费型接口：" + s));
	}

	private void happy(String s, Consumer<String> con) {
		con.accept(s);
	}

	@Test
	public void test2() {
		List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
		list.forEach(x -> System.out.println(x));
	}

	private List<Integer> getNumList(int num, Supplier<Integer> supp) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			list.add(supp.get());
		}

		return list;
	}

	@Test
	public void test3() {
		String str = handleStr("WoAiBeiJingTianAnMen", (x) -> x.toUpperCase());
		System.out.println("str: " + str);
	}

	private String handleStr(String s, Function<String, String> func) {
		return func.apply(s);
	}

	@Test
	public void test4() {
		List<String> list = Arrays.asList("wo", "ai", "beijing", "tiananmen", "tiananmen", "shang", "taiyang", "sheng");
		List<String> resultList = filterStr(list, (x) -> x.length() > 5);
		resultList.forEach(System.out::println);
	}

	private List<String> filterStr(List<String> strList, Predicate<String> pred) {
		List<String> list = new ArrayList<>();

		for (String s : strList) {
			if (pred.test(s)) {
				list.add(s);
			}
		}

		return list;
	}

}
