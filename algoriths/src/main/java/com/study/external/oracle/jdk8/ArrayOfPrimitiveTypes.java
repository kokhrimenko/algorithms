package com.study.external.oracle.jdk8;

import java.util.Arrays;

/**
 * Because the two references anyArray and otherArray refer to the same object
 * "object array" and the java always pass by value.
 * 
 * So the two calls of ArrayChallenge#doSom method has side-effect on "object
 * array " and the Stream#forEach accept Consumer<Integer> declared with the
 * idiom of method reference PrintStrema# print(int i).
 * 
 * @author kostya
 *
 */
public class ArrayOfPrimitiveTypes {
	public static void main(String... doYourBest) {
		int[] anyArray = new int[5];
		anyArray[0] = 0;
		anyArray[1] = 2;
		anyArray[2] = 4;
		anyArray[3] = 6;
		anyArray[4] = 8;

		int[] otherArray = anyArray;
		doSum(anyArray);
		doSum(otherArray);

		Arrays.stream(anyArray).forEach(System.out::println);
	}

	private static void doSum(int[] anyArray) {
		for (int i = 0; i < anyArray.length; i++) {
			anyArray[i] = anyArray[i] + 2;
		}
	}
}