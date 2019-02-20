package com.study.kokhrimenko.algoriths.array.practice.synchronize.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreExample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);

		Semaphore semaphore = new Semaphore(2);

		IntStream.range(0, 10).forEach(i -> executor.submit(() -> {
			boolean permit = false;
			try {
				permit = semaphore.tryAcquire(50, TimeUnit.MILLISECONDS);
				if (permit) {
					System.out.println("Semaphore acquired");
					Thread.sleep(200);
				} else {
					System.out.println("Could not acquire semaphore");
				}
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			} finally {
				if (permit) {
					semaphore.release();
				}
			}
		}));

		executor.shutdown();
	}

}
