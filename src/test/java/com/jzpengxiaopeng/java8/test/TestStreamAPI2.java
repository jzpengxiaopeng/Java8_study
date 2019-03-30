package com.jzpengxiaopeng.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.jzpengxiaopeng.java8.entity.Employee;
import com.jzpengxiaopeng.java8.entity.Employee.Status;

public class TestStreamAPI2 {
	List<Employee> employees = Arrays.asList(
			new Employee("关羽", 55, 55000, Status.FREE), 
			new Employee("张飞", 45, 50000, Status.BUSY),
			new Employee("马超", 40, 45000, Status.FREE), 
			new Employee("黄忠", 65, 45000, Status.BUSY), 
			new Employee("赵云", 35, 3000, Status.VACATION)
	);
	
	
	/*
	allMatch——检查是否匹配所有元素
	anyMatch——检查是否至少匹配一个元素
	noneMatch——检查是否没有匹配的元素
	findFirst——返回第一个元素
	findAny——返回当前流中的任意元素
	count——返回流中元素的总个数
	max——返回流中最大值
	min——返回流中最小值
	 */
	@Test
	public void test1() {
		boolean b1 = employees.stream().allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b1);
		
		boolean b2 = employees.stream().anyMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b2);
		
		boolean b3 = employees.stream().noneMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b3);
		
		Optional<Employee> op1 = employees.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).findFirst();
		System.out.println(op1);
		
		Optional<Employee> op2 = employees.parallelStream().filter((e) -> e.getStatus().equals(Status.FREE)).findAny();
		System.out.println(op2);
		
		long count = employees.stream().count();
		System.out.println(count);
		
		Optional<Employee> op3 = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(op3);
		
		Optional<Double> op4 = employees.stream().map(Employee::getSalary).min(Double::compare);
		System.out.println(op4);
	}
	
}
