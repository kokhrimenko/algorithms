package com.study.kokhrimenko.algoriths.external.leetcode;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || s.isEmpty()) {
			return s;
		}

		if (numRows == 1) {
			return s;
		}

		StringBuilder resultedString = new StringBuilder();
		int step = 2 * numRows - 2;

		for (int i = 0; i < numRows; i++) {
			if (i == 0 || i == numRows - 1) {
				for (int j = i; j < s.length(); j = j + step) {
					resultedString.append(s.charAt(j));
				}
			} else {
				int j = i;
				boolean flag = true;
				int step1 = 2 * (numRows - 1 - i);
				int step2 = step - step1;

				while (j < s.length()) {
					resultedString.append(s.charAt(j));
					if (flag)
						j = j + step1;
					else
						j = j + step2;
					flag = !flag;
				}
			}
		}

		return resultedString.toString();
	}
}
