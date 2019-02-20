package com.study.array.general;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRotateArray {
	private static final String FILE_NAME = RotateArray.class.getSimpleName() + ".txt";
	private static final String ARRAY_ITEM_DELIMITER = ",";
	private static final String ITEMS_DELIMITER = ";";

	private static final Logger logger = LoggerFactory.getLogger(TestRotateArray.class);
	
	@Test
	public void testExecutionFromFileDS() throws Exception {
		List<CaseDataItem> testedDataList = new ArrayList<>();		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(TestRotateArray.class.getResourceAsStream(FILE_NAME)))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] items = line.split(ITEMS_DELIMITER);
				if (items == null || items.length != 4) {
					throw new IllegalArgumentException("File with test data contains some wrong data: " + line);
				}
				testedDataList.add(new CaseDataItem(items[0], items[1], items[2], items[3]));
			}
		}

		if(testedDataList.isEmpty()) {
			throw new IllegalArgumentException("File with test data doesn't contains any data!");
		}
		logger.debug("Start to execute RotateArray test cases at: {}", new Date());
		for(CaseDataItem testCase : testedDataList) {
			logger.debug("Execute test story: {}", testCase.comment);
			execute(testCase.inputArray, testCase.expectedArray, testCase.k);
		}
		logger.debug("End to execute RotateArray test cases at: {}", new Date());
	}

	private void execute(int[] inputArray, int[] expectedArray, int k) {
		RotateArray executor = new RotateArray();

		execute((in, pos) -> executor.rotate(in, pos), createTestedArray(inputArray), expectedArray, k);
		execute((in, pos) -> executor.rotateBuble(in, pos), createTestedArray(inputArray),
				expectedArray, k);
		execute((in, pos) -> executor.rotateReversal(in, pos), createTestedArray(inputArray),
				expectedArray, k);
	}

	private int[] createTestedArray(int[] inputArray) {
		if (inputArray == null) {
			return null;
		}

		int[] testedArray = new int[inputArray.length];
		System.arraycopy(inputArray, 0, testedArray, 0, inputArray.length);
		return testedArray;
	}

	private void execute(BiConsumer<int[], Integer> executor, int[] inputArray, int[] expectedArray, int k) {
		executor.accept(inputArray, k);

		if (!Arrays.equals(inputArray, expectedArray)) {
			throw new RuntimeException("Arrays should be equals");
		}
	}
	
	private final class CaseDataItem {
		String comment;
		int[] inputArray = null;
		int[] expectedArray = null;
		int k;

		public CaseDataItem(String comment, String inputArrayAsStr, String expectedArrayAsStr, String kAsStr) {
			super();
			this.comment = comment;
			if(inputArrayAsStr != null && !inputArrayAsStr.trim().isEmpty()) {
				this.inputArray = Arrays.stream(inputArrayAsStr.trim().split(ARRAY_ITEM_DELIMITER)).mapToInt(Integer::parseInt).toArray();
			}
			if(expectedArrayAsStr != null && !expectedArrayAsStr.trim().isEmpty()) {
				this.expectedArray = Arrays.stream(expectedArrayAsStr.trim().split(ARRAY_ITEM_DELIMITER)).mapToInt(Integer::parseInt).toArray();
			}
			this.k = Integer.parseInt(kAsStr.trim());
		}		
	}
}
