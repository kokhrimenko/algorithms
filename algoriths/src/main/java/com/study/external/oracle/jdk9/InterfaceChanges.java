package com.study.external.oracle.jdk9;

import java.util.function.Function;

public class InterfaceChanges {

	interface Jedi {
		String MASTER = "Yoda";
		
		default String attack() {
			return jump(jedi -> String.join(jedi, useSaber(), useForce()));
		}
		
		private String jump(Function<String, String> function) {
			return function.apply("Luke");
		}
		
		private static String useSaber() {
			return "S";
		}
		
		private static String useForce() {
			return "F";
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Jedi() {
			public String useForce() {
				return "X";
			}			
		}.attack() + Jedi.useSaber() + Jedi.MASTER);
	}
}
