package com.study.kokhrimenko.algoriths.bit;

/**
 * Using the values 5 and 6 as examples, let's add them together using bitwise
 * operators.
 * 
 * x = 5 is 0101
 * y = 6 is 0110
 * 
 * While y is not 0 we perform AND on x and y. This yields 0100 or 4.
 * Next we perform XOR on x and y. This yields 0011 or 3.
 * Next we shift the carry by 1 to the left and set it equal to y.
 * This yields 1000 or 8. Since y is not yet 0, we go again.
 * 
 * x = 3 is 0011
 * y = 8 is 1000
 * 
 * We perform AND on x and y. This yields 0000 or 0. Our carry is 0.
 * Next we perform XOR on x and y. This yields 1011 or 11. Next we shift the
 * carry by 1 to the left and set it to y. This means that y is now 0. We are
 * done adding the two numbers.
 * 
 * Return: 11
 * 
 * @author k.okhrimenko
 *
 */
public class Add2NumbersBitTechique {

    public static void main(String[] args) {
        final int inputX = 22,
            inputY = 134;
        
        int x = inputX,
            y = inputY;
        while (y > 0) {
            int tmpY = x & y;
            x = x ^ y;
            y = tmpY << 1;
        }
        
        System.out.println(String.format("Results of %s + %s = %s", inputX, inputY, x));
    }

}
