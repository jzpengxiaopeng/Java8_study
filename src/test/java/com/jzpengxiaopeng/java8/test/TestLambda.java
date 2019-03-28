package com.jzpengxiaopeng.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.jzpengxiaopeng.java8.entity.Employee;
import com.jzpengxiaopeng.java8.predicate.EmployeeAgePredicate;
import com.jzpengxiaopeng.java8.predicate.MyPredicate;

public class TestLambda {

	List<Employee> employees = Arrays.asList(new Employee("关羽", 55, 55000), new Employee("张飞", 45, 50000),
			new Employee("马超", 40, 45000), new Employee("黄忠", 65, 45000), new Employee("赵云", 35, 3000));

	public List<Employee> filter(List<Employee> emps, MyPredicate<Employee> mp) {
		List<Employee> resultEmps = new ArrayList<>();

		for (Employee emp : emps) {
			if (mp.test(emp)) {
				resultEmps.add(emp);
			}
		}

		return resultEmps;
	}

	@Test
	public void test1() {
		List<Employee> emps = filter(employees, new EmployeeAgePredicate());
		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}

	@Test
	public void test2() {
		List<Employee> emps = filter(employees, new MyPredicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				return t.getAge() >= 40;
			}
		});
		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}

	@Test
	public void test3() {
		List<Employee> emps = filter(employees, (e) -> e.getAge() >= 40);
		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}

	@Test
	public void test4() {
		employees.stream().filter(e -> e.getAge() >= 40).forEach(System.out::println);
		System.out.println("------------------");
		employees.stream().filter(e -> e.getAge() >= 40).map(Employee::getName).forEach(System.out::println);
	}
}
