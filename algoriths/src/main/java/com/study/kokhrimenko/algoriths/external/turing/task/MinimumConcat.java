package com.study.kokhrimenko.algoriths.external.turing.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumConcat {

	private static int minimumConcat(String initial, String goal) {
		if(goal == null || goal.isEmpty() || initial == null || initial.isEmpty()) {
			return -1;
		}
		
		int result = 0;
		List<String> subStrings = subStrings(initial, initial.length());
		Collections.sort(subStrings, (str1, str2) -> str2.length() - str1.length());
		
		for(String replacement:subStrings) {
			String tmpGoal = goal.replace(replacement, "");
			if(!goal.equals(tmpGoal)) {
				result ++;
			}
			goal = tmpGoal;
		}
		return goal.isEmpty() ? result : -1;
    }
	
	private static List<String> subStrings(String str, int n) {
		List<String> results = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				results.add(str.substring(i, j));
			}
		}
		return results;
	}
	
	public static void main(String[] args) {
		String initial = "abc";
		String goal = "abcbc";
		
		System.out.println("minimumConcat: " + minimumConcat(initial, goal));
	}
	
}
