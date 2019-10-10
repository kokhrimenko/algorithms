package com.study.kokhrimenko.algoriths.bit;

/**
 * Count the set number of bits given a number.
 * 
 * Using 13 as an example let's count the number of set bits. 13 is 1101.
 * We know just by looking at it that it has 3 set bits. But how does our code know?
 * 
 * We use 1 to our advantage here.
 * Since 1 is 0001 we can perform AND on 1 and n to check if the LSB matches and then shift it right.
 * n = 13 or 1101
 * Counter: 0
 * 
 * First we perform AND on n and 1 yielding 0001. Add that to counter.
 * Counter: 1
 * Next shift the bits of n 1 to the right.
 * n is now 0110 or 6. 
 *
 * Perform AND again on and 1 giving us 0 since the LSB don't match. Add 0 to our counter.
 * Counter: 1
 * Shift the bits right again. n is now 0011 or 3. 
 * 
 * Perform AND on n and 1 giving us 1 and add that to our counter.
 * Counter: 2 
 * Shift the bits right. n is 0001 or 1.
 * 
 * Perform AND on n and 1 giving us 1 again and add it to our counter.
 * Counter: 3
 * Shift the bits right. n i now 0. We are done.
 * 
 * Return: 3
 * 
 * @author k.okhrimenko
 *
 */
public class BitsSetsInNumber {

    public static void main(String[] args) {
        final int inputX = 133;
        int n = inputX,
            counter = 0;
        while (n > 0) {
            counter += n & 1;
            n = n >> 1;
            
        }

        System.out.println(String.format("%s contains %s bits to set", inputX, counter));
    }

}
