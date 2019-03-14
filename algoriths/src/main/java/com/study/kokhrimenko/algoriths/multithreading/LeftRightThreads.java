package com.study.kokhrimenko.algoriths.multithreading;

public class LeftRightThreads extends Thread {

	private String name;
	private static Integer SYNC_ONJ = 1;
	
	public static void main(String[] args) {
		new LeftRightThreads("left").start();
		new LeftRightThreads("right").start();
	}

	public LeftRightThreads(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for(int i=0; i< 20; i++) {
			synchronized (SYNC_ONJ) {
				System.out.println(this.name);	
				try {
					SYNC_ONJ.notifyAll();
					SYNC_ONJ.wait(500);					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}
