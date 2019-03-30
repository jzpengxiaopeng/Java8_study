package com.jzpengxiaopeng.java8.test;

import java.util.Objects;
import java.util.Optional;

import org.junit.Test;

import com.jzpengxiaopeng.java8.entity.Dream;
import com.jzpengxiaopeng.java8.entity.Employee;
import com.jzpengxiaopeng.java8.entity.Man;

/*
 * 一、Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {

	@Test
	public void test1() {
		Optional<Employee> op = Optional.of(new Employee());
		System.out.println(op.get());
	}
	
	@Test
	public void test2() {
		Optional<Employee> op = Optional.empty();
		System.out.println(op.get());
		
		Optional<Employee> op2 = Optional.ofNullable(null);
		if (op2.isPresent()) {
			System.out.println(op2.get());
		}
	}
	
	@Test
	public void test3() {
		Optional<Employee> op = Optional.ofNullable(null);
		Employee emp = op.orElse(new Employee());
		System.out.println(emp);
		
		Employee emp2 = op.orElseGet(Employee::new);
		System.out.println(emp2);
	}
	
	@Test
	public void test4() {
		Optional<Employee> op = Optional.ofNullable(new Employee());
		Optional<String> nameOp = op.map(e -> e.getName());
		System.out.println(nameOp.get());
		
		Optional<String> nameOp2 = op.flatMap(e -> Optional.ofNullable(e.getName()));
		System.out.println(nameOp2.get());
	}
	
	@Test
	public void test5() {
		Optional<Man> op = Optional.of(new Man(Optional.of(new Dream("阿里P100"))));
		String dreamName = getDreamName(op);
		System.out.println("dreamName: " + dreamName);
	}
	
	private String getDreamName(Optional<Man> manOp) {
		Objects.requireNonNull(manOp);
		return manOp.orElseGet(Man::new).getDream().orElseGet(() -> new Dream("没有梦想")).getName();
	}
	
}
