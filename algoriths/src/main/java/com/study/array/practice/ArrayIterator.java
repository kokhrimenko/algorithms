package com.study.array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIterator {

	public static void main(String[] args) {
		List<Integer> intArray = new ArrayList<>(Arrays.asList(new Integer[] {1, 2, 3, 4}));
		
		java.util.Iterator<Integer> intArrayIterator = intArray.iterator();
		
		while(intArrayIterator.hasNext()) {
			Integer currentValue = intArrayIterator.next();
			if(currentValue % 2 == 0) {
				intArrayIterator.remove();
			}
		}
		
		System.out.println("Resulted array: ");
		intArray.forEach(System.out::println);
	}
	
}
