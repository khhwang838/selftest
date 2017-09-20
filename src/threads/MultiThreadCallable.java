package threads;
/**
 * �ۼ��� ��¥: 2014. 2. 18.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */

/**
 * @file .Callable.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * �� �� �� �� �� �� �� �� �� �� �� ��
 * ------------ ------------- ------------ ------------ 
 * Ȳ �� �� 2014. 2. 18. product ���� �� �� �� ��
 *
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
	
public class MultiThreadCallable implements Callable<Long> {

	private long total;
	
	public Long call() throws Exception {
		for (long i = 1; i <= 2000000; i++) {
			total += i;
		}
		return total;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Future<Long> f1 = executorService.submit(new MultiThreadCallable());
		Future<Long> f2 = executorService.submit(new MultiThreadCallable());
		Future<Long> f3 = executorService.submit(new MultiThreadCallable());
		Future<Long> f4 = executorService.submit(new MultiThreadCallable());
		Future<Long> f5 = executorService.submit(new MultiThreadCallable());
		Future<Long> f6 = executorService.submit(new MultiThreadCallable());
		System.out.printf("[%s] 1���� 20000������ �� ���� %d�Դϴ�.%n", "f1", f1.get());
		System.out.printf("[%s] 1���� 20000������ �� ���� %d�Դϴ�.%n", "f2", f2.get());
		System.out.printf("[%s] 1���� 20000������ �� ���� %d�Դϴ�.%n", "f3", f3.get());
		System.out.printf("[%s] 1���� 20000������ �� ���� %d�Դϴ�.%n", "f4", f4.get());
		System.out.printf("[%s] 1���� 20000������ �� ���� %d�Դϴ�.%n", "f5", f5.get());
		System.out.printf("[%s] 1���� 20000������ �� ���� %d�Դϴ�.%n", "f6", f6.get());
		executorService.shutdown();
	}
	
}

