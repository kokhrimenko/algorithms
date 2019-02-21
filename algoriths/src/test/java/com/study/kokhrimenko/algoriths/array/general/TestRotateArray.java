package com.study.kokhrimenko.algoriths.array.general;

import java.util.Arrays;
import java.util.function.BiConsumer;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;
import com.study.kokhrimenko.algoriths.infrastructure.TestCaseItemData;

public class TestRotateArray extends JUnitStory<TestRotateArray.CaseDataItem> {	
	private static final String ARRAY_ITEM_DELIMITER = ",";

	public TestRotateArray() {
		super(RotateArray.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
	}
	
	@Override
	protected void execute(CaseDataItem tcData) {
		RotateArray executor = new RotateArray();

		execute((in, pos) -> executor.rotate(in, pos), createTestedArray(tcData.inputArray), tcData.expectedArray, tcData.k);
		execute((in, pos) -> executor.rotateBuble(in, pos), createTestedArray(tcData.inputArray),
				tcData.expectedArray, tcData.k);
		execute((in, pos) -> executor.rotateReversal(in, pos), createTestedArray(tcData.inputArray),
				tcData.expectedArray, tcData.k);
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
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
	
	protected static final class CaseDataItem implements TestCaseItemData {
		final String comment;
		final int[] inputArray;
		final int[] expectedArray;
		final int k;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;
			String inputArrayAsStr = params[0].toString();			
			if (inputArrayAsStr != null && !inputArrayAsStr.isEmpty()) {
				this.inputArray = Arrays.stream(inputArrayAsStr.split(ARRAY_ITEM_DELIMITER))
						.mapToInt(Integer::parseInt).toArray();
			} else {
				this.inputArray = null;
			}
			
			String expectedArrayAsStr = params[1].toString();			
			if (expectedArrayAsStr != null && !expectedArrayAsStr.isEmpty()) {
				this.expectedArray = Arrays.stream(expectedArrayAsStr.split(ARRAY_ITEM_DELIMITER))
						.mapToInt(Integer::parseInt).toArray();
			} else {
				this.expectedArray = null;
			}
			
			String kAsStr = params[2].toString();
			
			this.k = Integer.parseInt(kAsStr);
		}

		@Override
		public String getComment() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
