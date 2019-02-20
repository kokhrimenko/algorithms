package com.study.kokhrimenko.algoriths.array.general;

import java.util.Arrays;
import java.util.function.BiConsumer;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;
import com.study.kokhrimenko.algoriths.infrastructure.ReflectionCreatedClass;

public class TestRotateArray extends JUnitStory<TestRotateArray.CaseDataItem> {	
	private static final String ARRAY_ITEM_DELIMITER = ",";

	public TestRotateArray() {
		super(RotateArray.class, new CaseDataItem());
	}
	
	@Test
	public void testExecutionFromFileDS() throws Exception {
		markTestStart();
		for(CaseDataItem testCase : testedDataSet) {
			getLogger().debug("Execute test story: {}", testCase.comment);
			execute(testCase.inputArray, testCase.expectedArray, testCase.k);
		}
		markTestEnd();
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
	
	protected static final class CaseDataItem implements ReflectionCreatedClass<CaseDataItem>{
		String comment;
		int[] inputArray = null;
		int[] expectedArray = null;
		int k;

		public CaseDataItem() {
			super();
		}
		
		private CaseDataItem(String comment, int[] inputArray, int[] expectedArray, int k) {
			super();
			this.comment = comment;
			this.inputArray = inputArray;
			this.expectedArray = expectedArray;
			this.k = k;
		}

		@Override
		public int getAllowedCountOfConstructorArguments() {
			return 4;
		}

		@Override
		public CaseDataItem instanciate(Object... params) {
			String comment = params[0].toString();
			String inputArrayAsStr = params[1].toString();
			int[] inputArray = null;
			if (inputArrayAsStr != null && !inputArrayAsStr.trim().isEmpty()) {
				inputArray = Arrays.stream(inputArrayAsStr.trim().split(ARRAY_ITEM_DELIMITER))
						.mapToInt(Integer::parseInt).toArray();
			}
			
			String expectedArrayAsStr = params[2].toString();
			int[] expectedArray = null;
			if (expectedArrayAsStr != null && !expectedArrayAsStr.trim().isEmpty()) {
				expectedArray = Arrays.stream(expectedArrayAsStr.trim().split(ARRAY_ITEM_DELIMITER))
						.mapToInt(Integer::parseInt).toArray();
			}
			
			String kAsStr = params[3].toString();
			int k = Integer.parseInt(kAsStr.trim());
			
			return new CaseDataItem(comment, inputArray, expectedArray, k);
		}
	}
}
