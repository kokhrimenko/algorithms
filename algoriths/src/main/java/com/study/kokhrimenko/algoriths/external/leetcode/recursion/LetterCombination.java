package com.study.kokhrimenko.algoriths.external.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * Example: 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * @author kostic
 *
 */
public class LetterCombination {
	private static final Map<String, List<String>> DIGIT_TO_LETTER;
	static {
		DIGIT_TO_LETTER = new HashMap<>();

		DIGIT_TO_LETTER.put("2", Arrays.asList("a", "b", "c"));
		DIGIT_TO_LETTER.put("3", Arrays.asList("d", "e", "f"));
		DIGIT_TO_LETTER.put("4", Arrays.asList("g", "h", "i"));
		DIGIT_TO_LETTER.put("5", Arrays.asList("j", "k", "l"));
		DIGIT_TO_LETTER.put("6", Arrays.asList("m", "n", "o"));
		DIGIT_TO_LETTER.put("7", Arrays.asList("p", "q", "r", "s"));
		DIGIT_TO_LETTER.put("8", Arrays.asList("t", "u", "v"));
		DIGIT_TO_LETTER.put("9", Arrays.asList("w", "x", "y", "z"));
	}

	public static void main(String[] args) {
		String input = "237";
		LetterCombination executor = new LetterCombination();
		System.out.println(executor.letterCombinations(input));
	}
	
	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.isEmpty()) {
			return Collections.emptyList();
		}
		List<String> result = new ArrayList<>();
		this.combine(digits, "", result);
		return result;
	}
	
	private void combine(String digits, String combination, List<String> accumulator) {
		if(digits.isEmpty()) {
			accumulator.add(combination);
			return;
		}
		String digit = digits.substring(0, 1);
		for(String letter:DIGIT_TO_LETTER.get(digit)) {
			combine(digits.substring(1), combination + letter, accumulator);
		}
	}
}
