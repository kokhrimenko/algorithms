package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestTwoSums extends JUnitStory<TestTwoSums.CaseDataItem>{

	public TestTwoSums() {
		super(TwoSums.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
	}

	@Test
	public void testExecutionFromFileDS() throws Exception {
		markTestStart();
		for(CaseDataItem testCase : testedDataSet) {
			getLogger().debug("Execute test story: {}", testCase.comment);
			execute(testCase);
		}
		markTestEnd();
	}
	
	private void execute(CaseDataItem inputItem) {
		TwoSums executor = new TwoSums();
		int[] resultedArray = executor.twoSum(inputItem.inputArray, inputItem.target);
		assertNotNull(resultedArray);
		assertEquals(inputItem.expectedArray.length, resultedArray.length);
		for(int i=0; i<inputItem.expectedArray.length; i++) {
			assertEquals(inputItem.expectedArray[i], resultedArray[i]);
		}
	}
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
	
	protected static final class CaseDataItem {
		String comment;
		int[] inputArray;
		int target;
		int[] expectedArray;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;
			this.inputArray = generateIntArrayFromInputParams(params[0]);
			this.target = Integer.parseInt(params[1].trim());
			this.expectedArray = generateIntArrayFromInputParams(params[2]);
		}
	}

	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 4;
	}
	
}
