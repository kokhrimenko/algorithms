package com.study.array.practice.synchronize.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * Original link: https://www.baeldung.com/java-phaser
 * @author kostic
 *
 */
public class PhaserExample {

	private static class LongRunningAction implements Runnable {
		private String threadName;
		private Phaser ph;

		LongRunningAction(String threadName, Phaser ph) {
			this.threadName = threadName;
			this.ph = ph;
			ph.register();
		}

		@Override
		public void run() {
			ph.arriveAndAwaitAdvance();
			System.out.println(String.format("start execution thread %s, phase: %s", threadName, ph.getPhase()));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ph.arriveAndDeregister();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Phaser ph = new Phaser(1);

		assert 0 == ph.getPhase();
		
		executorService.submit(new LongRunningAction("thread-1", ph));
		executorService.submit(new LongRunningAction("thread-2", ph));
		executorService.submit(new LongRunningAction("thread-3", ph));
		 
		ph.arriveAndAwaitAdvance();
		  
		assert 1 == ph.getPhase();

		executorService.submit(new LongRunningAction("thread-4", ph));
		executorService.submit(new LongRunningAction("thread-5", ph));
		ph.arriveAndAwaitAdvance();
		  
		assert 2 == ph.getPhase();
		 
		ph.arriveAndDeregister();
		executorService.shutdown();
	}
}
