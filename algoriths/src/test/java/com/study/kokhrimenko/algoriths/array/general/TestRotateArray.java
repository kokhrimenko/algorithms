package com.study.kokhrimenko.algoriths.array.general;

import java.util.Arrays;
import java.util.function.BiConsumer;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestRotateArray extends JUnitStory<TestRotateArray.CaseDataItem> {	
	private static final String ARRAY_ITEM_DELIMITER = ",";

	public TestRotateArray() {
		super(RotateArray.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
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

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;
			String inputArrayAsStr = params[0].toString();
			if (inputArrayAsStr != null && !inputArrayAsStr.trim().isEmpty()) {
				this.inputArray = Arrays.stream(inputArrayAsStr.trim().split(ARRAY_ITEM_DELIMITER))
						.mapToInt(Integer::parseInt).toArray();
			}
			
			String expectedArrayAsStr = params[1].toString();
			if (expectedArrayAsStr != null && !expectedArrayAsStr.trim().isEmpty()) {
				this.expectedArray = Arrays.stream(expectedArrayAsStr.trim().split(ARRAY_ITEM_DELIMITER))
						.mapToInt(Integer::parseInt).toArray();
			}
			
			String kAsStr = params[2].toString();
			this.k = Integer.parseInt(kAsStr.trim());
		}
	}

	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
}
