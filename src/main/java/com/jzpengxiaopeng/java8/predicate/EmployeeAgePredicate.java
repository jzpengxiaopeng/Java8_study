package com.jzpengxiaopeng.java8.predicate;

import com.jzpengxiaopeng.java8.entity.Employee;

public class EmployeeAgePredicate implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getAge() >= 40;
	}

}
