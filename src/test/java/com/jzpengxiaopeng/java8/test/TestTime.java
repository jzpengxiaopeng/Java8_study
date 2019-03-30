package com.jzpengxiaopeng.java8.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class TestTime {

	@Test
	public void test1() {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
		
		Callable<LocalDate> task = () -> LocalDate.parse("2019-03-30", dtf);
		
		List<Future<LocalDate>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Future<LocalDate> future = threadPool.submit(task);
			list.add(future);
		}
		
		list.forEach((f) -> {
			try {
				System.out.println(f.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
	}
	
}
