package com.jzpengxiaopeng.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.jzpengxiaopeng.java8.entity.Trader;
import com.jzpengxiaopeng.java8.entity.Transaction;

/**
 * 练习题
 */
public class TestStreamExer2 {
	List<Transaction> transactions = null;

	@Before
	public void before() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		transactions = Arrays.asList(
				new Transaction(brian, 2011, 300), 
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), 
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
			);
	}

	// 1、找出2011年发生的交易，并按照交易额由低到高进行排序
	@Test
	public void test1() {
		transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue())).forEach(System.out::println);
	}

	// 2、交易员都在哪些不同的城市工作过？
	@Test
	public void test2() {
		transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().forEach(System.out::println);
	}

	// 3、查找所有来自剑桥的交易员，并按照姓名排序
	@Test
	public void test3() {
		transactions.stream().map(Transaction::getTrader).filter(tr -> tr.getCity().equals("Cambridge")).distinct()
				.sorted((tr1, tr2) -> tr1.getName().compareTo(tr2.getName())).forEach(System.out::println);
	}

	// 4、返回所有交易员的姓名字符串，按照字母顺序排序
	@Test
	public void test4() {
		transactions.stream().map(Transaction::getTrader).distinct().map(Trader::getName).sorted()
				.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		
		transactions.stream().map(t -> t.getTrader().getName()).flatMap(TestStreamExer2::map).sorted().forEach(System.out::print);
		
		System.out.println("-----------------------------------------");
		
		transactions.stream().map(t -> t.getTrader().getName()).flatMap(TestStreamExer2::map2).sorted(String::compareToIgnoreCase).forEach(System.out::print);
	}
	
	private static Stream<Character> map(String str) {
		List<Character> list = new ArrayList<>();
		
		for (Character c : str.toCharArray()) {
			list.add(c);
		}
		
		return list.stream();
	}
	
	private static Stream<String> map2(String str) {
		List<String> list = new ArrayList<>();
		
		for (Character c : str.toCharArray()) {
			list.add(c.toString());
		}
		
		return list.stream();
	}

	// 5、有没有交易员是在米兰工作的？
	@Test
	public void test5() {
		boolean b = transactions.stream().map(Transaction::getTrader).anyMatch(t -> t.getCity().equals("Milan"));
		System.out.println(b);
	}

	// 6、打印生活在剑桥的交易员的所有交易额
	@Test
	public void test6() {
		transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue)
				.forEach(System.out::println);
	}

	// 7、所有交易中，最高的交易额是多少
	@Test
	public void test7() {
		Optional<Transaction> max = transactions.stream()
				.max((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
		System.out.println(max.get().getValue());

		System.out.println("-----------------------------");

		Optional<Transaction> max2 = transactions.stream()
				.collect(Collectors.maxBy((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue())));
		System.out.println(max2.get().getValue());

		System.out.println("-----------------------------");

		Optional<Integer> max3 = transactions.stream().map(Transaction::getValue)
				.collect(Collectors.maxBy(Integer::compare));
		System.out.println(max3.get());
	}

	// 8、找到交易额最小的交易
	@Test
	public void test8() {
		Optional<Transaction> min = transactions.stream()
				.collect(Collectors.minBy((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue())));
		System.out.println(min.get());
	}

}
