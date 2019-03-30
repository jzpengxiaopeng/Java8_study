package com.jzpengxiaopeng.java8.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCacalutor extends RecursiveTask<Long> {

	private static final long serialVersionUID = 7963230069248657255L;

	private Long start;

	private Long end;

	public ForkJoinCacalutor(Long start, Long end) {
		super();
		this.start = start;
		this.end = end;
	}

	private static final Long THRESHOLD = 10000L;

	/*
	@Override
	protected Long compute() {
		if (end - start <= THRESHOLD) {
			Long sum = 0L;
			for (Long i = start; i <= THRESHOLD; i++) {
				sum += i;
			}
			return sum;
		} else {
			long mid = (end + start) / 2;

			ForkJoinCacalutor left = new ForkJoinCacalutor(start, mid);
			left.fork();

			ForkJoinCacalutor right = new ForkJoinCacalutor(mid + 1, end);
			right.fork();

			return left.join() + right.join();
		}
	}
	*/
	
	@Override
	protected Long compute() {
		long length = end - start;
		
		if(length <= THRESHOLD){
			long sum = 0;
			
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			
			return sum;
		}else{
			long middle = (start + end) / 2;
			
			ForkJoinCacalutor left = new ForkJoinCacalutor(start, middle);
			left.fork(); //拆分，并将该子任务压入线程队列
			
			ForkJoinCacalutor right = new ForkJoinCacalutor(middle+1, end);
			right.fork();
			
			return left.join() + right.join();
		}
		
	}

}
