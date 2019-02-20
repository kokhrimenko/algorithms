package com.study.kokhrimenko.algoriths.array.general;

import java.util.Arrays;
import java.util.function.BiConsumer;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestRotateArray extends JUnitStory<TestRotateArray.CaseDataItem> {	
	public TestRotateArray() {
		super(RotateArray.class, params -> new CaseDataItem(params));
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
	
	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 4;
	}
	
	protected static final class CaseDataItem {
		String comment;
		int[] inputArray = null;
		int[] expectedArray = null;
		int k;

		public CaseDataItem(Object... params) {
			this.comment = params[0].toString();
			this.inputArray = generateIntArrayFromInputParams(params[1].toString());
			this.expectedArray = generateIntArrayFromInputParams(params[2].toString());
			
			String kAsStr = params[3].toString();
			this.k = Integer.parseInt(kAsStr.trim());
		}		
	}
}
