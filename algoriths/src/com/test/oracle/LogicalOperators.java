package com.test.oracle;

/**
 * int a = 0; 
 * int b = a++; // b = 0; a = 1
 * 
 * a = 0;
 * b = ++a: // b = 1; a = 1
 * 
 * @author kostya
 *
 */
public class LogicalOperators {

    public static void main(String[] args) {

        int spiderMan = 10;
        int venom = 5;
        int carnage = 50;

        if (spiderMan == 11 & venom++ == 5) {
            venom++;
        }

        if (++carnage == 50 | spiderMan++ == 11 | spiderMan++ == 12 | 
                              spiderMan++ == 13 | spiderMan++ == 14) {
            venom++;
        }

        if (++spiderMan == 14 | spiderMan++ == 15 & venom++ == 6 & spiderMan == 13) {
            spiderMan++;
        }
        System.out.println(spiderMan + venom + carnage);
    }

}
