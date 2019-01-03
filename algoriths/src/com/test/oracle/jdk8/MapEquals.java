package com.test.oracle.jdk8;

import java.util.HashMap;
import java.util.Map;

public class MapEquals {
	public static void main(String[] args) {
		Map<Stark, String> map = new HashMap<>();
		map.put(new Stark("Arya"), "1");
		map.put(new Stark("Ned"), "2");
		map.put(new Stark("Sansa"), "3");
		map.put(new Stark("Bran"), "4");
		map.put(new Stark("Jaime"), "5");
		
		map.forEach((k, v) -> System.out.println(v));
		
	}
	
	static class Stark {
		String name;
		
		public Stark(String name) {
			this.name = name;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return ((Stark) obj).name.length() == this.name.length();
		}
		
		@Override
		public int hashCode() {
			return 4000 << 2 * 2000 / 10000;
		}
	}
}
