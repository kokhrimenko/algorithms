package com.study.kokhrimenko.algoriths.external.oracle.jdk9;

import java.io.Closeable;
import java.io.IOException;

public class ExceptionChallenge2 {

	public static void main(String[] args) {
		String soprano = null;
		
		CloseIt closeIt = new CloseIt();
		try(closeIt) {
			System.out.println(soprano.matches(null));
		} catch (RuntimeException r) {
			try(closeIt) {
				System.out.println("runtime");
				
				throw new StackOverflowError();
			} catch (Exception e) {
				System.out.println("exception");
			}
		} catch (Error exception) {
			System.out.println("error");
		} catch (Throwable throwable) {
			System.out.println("throwable");
		}
	}
	
	static class CloseIt implements Closeable {
		
		@Override
		public void close() throws IOException {
			System.out.println("close");
		}
		
	}
	
}
