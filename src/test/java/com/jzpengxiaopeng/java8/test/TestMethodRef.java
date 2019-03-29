package com.jzpengxiaopeng.java8.test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.jzpengxiaopeng.java8.entity.Employee;

/*
 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 * 
 * 1. 对象的引用 :: 实例方法名
 * 
 * 2. 类名 :: 静态方法名
 * 
 * 3. 类名 :: 实例方法名
 * 
 * 注意：
 * 	 ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 	 ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 * 
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 * 
 * 1. 类名 :: new
 * 
 * 三、数组引用
 * 
 * 	类型[] :: new;
 * 
 * 
 */
public class TestMethodRef {

	@Test
	public void test1() {
		Consumer<String> con = (s) -> System.out.println(s);
		con.accept("我爱北京天安门");

		System.out.println("---------------------------------");

		Consumer<String> con2 = System.out::println;
		con2.accept("天安门上太阳升");
	}

	@Test
	public void test2() {
		Employee emp = new Employee("杰克逊", 45, 70000);

		Supplier<String> supp = () -> emp.getName();
		System.out.println(supp.get());

		System.out.println("---------------------------------");

		Supplier<String> supp2 = emp::getName;
		System.out.println(supp2.get());
	}

	@Test
	public void test3() {
		BiFunction<Double, Double, Double> biFunc = (x, y) -> Math.max(x, y);
		System.out.println(biFunc.apply(1.5, 2.3));

		System.out.println("---------------------------------");

		BiFunction<Double, Double, Double> biFunc2 = Math::max;
		System.out.println(biFunc2.apply(1.5, 2.3));
	}

	@Test
	public void test4() {
		Comparator<Integer> comp = (x, y) -> Integer.compare(x, y);
		comp.compare(1, 2);

		System.out.println("---------------------------------");

		Comparator<Integer> comp2 = Integer::compare;
		comp2.compare(1, 2);
	}

	@Test
	public void test5() {
		BiPredicate<String, String> biPred = (s1, s2) -> s1.equals(s2);
		System.out.println(biPred.test("abc", "abc"));

		System.out.println("---------------------------------");

		BiPredicate<String, String> biPred2 = String::equals;
		System.out.println(biPred2.test("abcd", "abc"));

		System.out.println("---------------------------------");

		Function<Employee, String> func = (e) -> e.show();
		System.out.println(func.apply(new Employee("张无忌", 25, 3000)));

		System.out.println("---------------------------------");

		Function<Employee, String> func2 = Employee::show;
		System.out.println(func2.apply(new Employee("敏敏特木耳", 23, 30000000)));
	}
	
	@Test
	public void test6() {
		Supplier<Employee> supp = () -> new Employee();
		System.out.println(supp.get());
		
		System.out.println("---------------------------------");
		
		Supplier<Employee> supp2 = Employee::new;
		System.out.println(supp2.get());
	}
	
	@Test
	public void test7() {
		Function<String, Employee> func = (s) -> new Employee(s);
		System.out.println(func.apply("成昆"));
		
		System.out.println("---------------------------------");
		
		Function<String, Employee> func2 = Employee::new;
		System.out.println(func2.apply("圆真"));
		
		System.out.println("---------------------------------");
		
		BiFunction<String, Integer, Employee> func3 = Employee::new;
		System.out.println(func3.apply("谢逊", 42));
	}
	
	@Test
	public void test8() {
		Function<Integer, String[]> func = (n) -> new String[n];
		String[] arr = func.apply(10);
		System.out.println(arr.length);
		
		System.out.println("---------------------------------");
		
		Function<Integer, String[]> func2 = String[]::new;
		String[] arr2 = func2.apply(20);
		System.out.println(arr2.length);
	}

}
