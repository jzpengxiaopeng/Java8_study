package com.jzpengxiaopeng.java8.test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.jzpengxiaopeng.java8.entity.Employee;
import com.jzpengxiaopeng.java8.entity.Employee.Status;

public class TestStreamAPI3 {
	List<Employee> employees = Arrays.asList(
			new Employee("关羽", 55, 55000, Status.FREE), 
			new Employee("张飞", 45, 50000, Status.BUSY),
			new Employee("马超", 40, 45000, Status.FREE), 
			new Employee("黄忠", 65, 45000, Status.BUSY), 
//			new Employee("黄忠", 65, 45000, Status.BUSY), 
//			new Employee("黄忠", 65, 45000, Status.BUSY), 
//			new Employee("黄忠", 65, 45000, Status.BUSY), 
			new Employee("赵云", 35, 3000, Status.VACATION)
	);
	
	@Test
	public void test1() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 8, 9, 10);
		Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println(reduce);
		
		System.out.println("------------------------------");
		
		Optional<Double> reduce2 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println(reduce2.get());
	}
	
	@Test
	public void test2() {
		List<String> list = employees.stream().map(Employee::getName).collect(Collectors.toList());
		list.forEach(System.out::println);
		
		System.out.println("--------------------------------");
		
		Set<String> set = employees.stream().map(Employee::getName).collect(Collectors.toSet());
		set.forEach(System.out::println);
		
		System.out.println("--------------------------------");
		
		HashSet<String> hashSet = employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
		hashSet.forEach(System.out::println);
	}
	
	@Test
	public void test3() {
		Long count = employees.stream().collect(Collectors.counting());
		System.out.println(count);
		
		Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avg);
		
		Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		
		Optional<Employee> max = employees.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
		System.out.println(max.get());
		
		Optional<Double> min = employees.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
		System.out.println(min.get());
		
		DoubleSummaryStatistics summarizer = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(summarizer);
	}
	
	@Test
	public void test4() {
		Map<Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(map);
	}
	
	@Test
	public void test5() {
		Map<Status, Map<String, List<Employee>>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e -> {
			if (e.getAge() < 35) {
				return "青年";
			} else if (e.getAge() < 50) {
				return "中年";
			} else {
				return "老年";
			}
		}))));
		
		System.out.println(map);
	}
	
	@Test
	public void test6() {
		Map<Boolean, List<Employee>> map = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 30000));
		System.out.println(map);
	}
	
	@Test
	public void test7() {
		String joinStr = employees.stream().map(Employee::getName).collect(Collectors.joining());
		System.out.println(joinStr);
		
		System.out.println("--------------------------");
		
		String joinStr2 = employees.stream().map(Employee::getName).collect(Collectors.joining(",", "---", "+++++"));
		System.out.println(joinStr2);
		
	}
}
