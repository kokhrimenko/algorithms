package com.study.kokhrimenko.algoriths.bit;

/**
 * ^ (XOR) ^ also known as XOR stands for Exclusive Or.
 * When we compare two values it returns a binary value where the set bits are all the pairs of bits
 * that did not match.
 * It is a very fast and space efficient way to check for duplicates.
 * A common problem that shows up in some technical interviews is when given a natural set of numbers S which contains duplicates of every
 * element except for a unique number x, find x as fast and memory efficient as possible.
 * You could potentially sort it and check for pairs, but that would mean our solution has a time complexity of O(n log n).
 * Or on the flip side we could create a Set and have a linear time complexity, but that would also mean we have a linear space complexity.
 * We can easily check for a duplicate in linear time and constant space using XOR.
 * 
 * @author k.okhrimenko
 *
 */
public class UniqueIntoArray {

    public static void main(String[] args) {
        int[] inputArr = { 2, 1, 2, 1, 4, 3, 5, 7, 7, 3, 5, 8, 9, 9, 4 };
        int result = inputArr[0];
        for (int i = 1; i < inputArr.length; i++) {
            result = result ^ inputArr[i];
        }

        System.out.println("Result is: " + result);
    }

}
