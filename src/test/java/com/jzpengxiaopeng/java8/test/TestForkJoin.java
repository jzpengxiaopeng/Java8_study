package com.jzpengxiaopeng.java8.test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

import com.jzpengxiaopeng.java8.forkjoin.ForkJoinCacalutor;

public class TestForkJoin {
	
	Long max = 100000000000L;

	@Test
	public void test1() {
		Instant start = Instant.now();
		
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> fjc = new ForkJoinCacalutor(0L, max);
		Long result = pool.invoke(fjc);
		
		Instant end = Instant.now();
		
		System.out.println("result: " + result + ", cost: " + Duration.between(start, end).toMillis() + " ms");
	}
	
	@Test
	public void test2() {
		Instant start = Instant.now();
		
		Long result = 0L;
		
		for (Long i = 0L; i < max; i++) {
			result += i;
		}
		
		Instant end = Instant.now();
		
		System.out.println("result: " + result + ", cost: " + Duration.between(start, end).toMillis() + " ms");
	}
	
	@Test
	public void test3() {
		Instant start = Instant.now();
		
		long result = LongStream.rangeClosed(0L, max).parallel().reduce(0L, Long::sum);
		
		Instant end = Instant.now();
		
		System.out.println("result: " + result + ", cost: " + Duration.between(start, end).toMillis() + " ms");
	}
	
	
}
