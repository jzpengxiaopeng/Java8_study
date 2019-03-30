package com.jzpengxiaopeng.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import com.jzpengxiaopeng.java8.entity.Employee;
import com.jzpengxiaopeng.java8.entity.Employee.Status;

/**
 * 练习题
 */
public class TestStreamExer {

	List<Employee> emps = Arrays.asList(
			new Employee("关羽", 55, 55000, Status.FREE), 
			new Employee("张飞", 45, 50000, Status.BUSY),
			new Employee("马超", 40, 45000, Status.FREE), 
			new Employee("黄忠", 65, 45000, Status.BUSY), 
			new Employee("黄忠", 65, 45000, Status.BUSY), 
			new Employee("黄忠", 65, 45000, Status.BUSY), 
			new Employee("黄忠", 65, 45000, Status.BUSY), 
			new Employee("赵云", 35, 3000, Status.VACATION)
	);
	
	@Test
	public void test1() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> newList = list.stream().map(i -> i * i).collect(Collectors.toList());
		newList.forEach(System.out::println);
	}
	
	@Test
	public void test2() {
		Optional<Integer> op = emps.stream().map(e -> 1).reduce(Integer::sum);
		System.out.println(op.get());
	}
}
