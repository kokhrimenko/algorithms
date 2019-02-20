package com.study.kokhrimenko.algoriths.external.oracle.jdk8;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TokenizerChallenge {
    public static void main(String[] args) {
       Scanner sc = new Scanner("ThisIsIt,theFinalString,NoBugsProject");
       
       Pattern pattern = Pattern.compile("[^\\w*]");
       sc.useDelimiter(pattern);
      
       while (sc.hasNext()) {
           System.out.println(sc.next());
       }

       sc.close();
    }
}