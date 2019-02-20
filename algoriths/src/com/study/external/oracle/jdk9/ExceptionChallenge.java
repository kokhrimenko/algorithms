package com.study.external.oracle.jdk9;

import java.io.Closeable;
import java.io.IOException;

public class ExceptionChallenge {

	static String marvelHero = "";
	
	public static void main(String[] args) throws Exception {
		Logan logan = new Logan();
		new ExceptionChallenge().executeAction(new PeterParker(), logan);
		System.out.println(marvelHero + logan.wolverineCloseCount);
	}
	
	private void executeAction(Closeable spiderMan, AutoCloseable wolverine) throws Exception {
		try(spiderMan; wolverine) {
			wolverine.close();
		} catch (Exception e) {
			marvelHero += "?";
			spiderMan.close();
		}
	}
	
	static class PeterParker implements Closeable {

		@Override
		public void close() throws IOException {
			marvelHero += "#";
		}
		
	}
	
	static class Logan implements AutoCloseable {
		int wolverineCloseCount = 0;

		@Override
		public void close() throws Exception {
			marvelHero += ">";
			wolverineCloseCount ++;
			
			if(wolverineCloseCount >= 1) {
				throw new IOException();
			}
		}
		
		
	}
	
}
