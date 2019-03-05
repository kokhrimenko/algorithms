package com.study.kokhrimenko.algoriths.external.leetcode;

public class IntegerToRoman {
	public static void main(String[] args) {
		IntegerToRoman executor = new IntegerToRoman();
		int inputValue = 3927;
		
		System.out.println(executor.intToRoman(inputValue));
	}
	public String intToRoman(int num) {
		StringBuilder resultedString = new StringBuilder();
		
		if(num / 1000 > 0) {
			int number = num / 1000;
			resultedString.append(repeatSymbol("M", number));
			num -= number * 1000;
		}
		
		num = this.generateDecimalFraction(num, resultedString, 100, "M", "D", "C");
		num = this.generateDecimalFraction(num, resultedString, 10, "C", "L", "X");
		num = this.generateDecimalFraction(num, resultedString, 1, "X", "V", "I");
		
        return resultedString.toString();
    }
	
	private String repeatSymbol(String symbol, int repeatTime) {
		return repeatTime > 0 ?  repeatSymbol(symbol, repeatTime -1) + symbol: ""; 	
	}
	
	private int generateDecimalFraction(int num, StringBuilder resultedString, int fraction, String highSymbol, String midSymbol, String normalSymbol) {
		if(num / fraction > 0) {
			if(num >= 9 * fraction) {
				resultedString.append(String.format("%s%s", normalSymbol, highSymbol));
				num -= 9 * fraction;
			}
			
			if(num >= 5 * fraction) {
				resultedString.append(midSymbol);
				num -= 5 * fraction;
			}
			
			if(num >= 4 * fraction) {
				resultedString.append(String.format("%s%s", normalSymbol, midSymbol));
				num -= 4 * fraction;
			}
			
			int number = num / fraction;
			if(number > 0) {
				resultedString.append(repeatSymbol(normalSymbol, number));
				num -= number * fraction;
			}
		}
		
		return num;
	}
}
