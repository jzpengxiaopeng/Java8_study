package com.jzpengxiaopeng.java8.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.jzpengxiaopeng.java8.util.ThreadLocalDateUtil;

public class TestSimpleDateFormat {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws Exception {
		// wrongMethod();
		rightMethod();
	}

	private static void wrongMethod() throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		
		Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				return sdf.parse("2019-03-30");
			}
		};
		
		List<Future<Date>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Future<Date> future = threadPool.submit(task);
			list.add(future);
		}
		
		for (Future<Date> future : list) {
			System.out.println(future.get());
		}
		
		threadPool.shutdown();
	}
	
	private static void rightMethod() throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		
		Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				return ThreadLocalDateUtil.getDate("2019-03-30");
			}
		};
		
		List<Future<Date>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Future<Date> future = threadPool.submit(task);
			list.add(future);
		}
		
		for (Future<Date> future : list) {
			System.out.println(future.get());
		}
		
		threadPool.shutdown();
	}
}
