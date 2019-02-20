package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestTwoSums extends JUnitStory<TestTwoSums.CaseDataItem>{

	public TestTwoSums() {
		super(TwoSums.class,  params -> new CaseDataItem(params));
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
	
	protected static final class CaseDataItem {
		String comment;
		int[] inputArray;
		int target;
		int[] expectedArray;

		public CaseDataItem(Object... params) {
			this.comment = params[0].toString();
			this.inputArray = generateIntArrayFromInputParams(params[1].toString());
			this.target = Integer.parseInt(params[2].toString().trim());
			this.expectedArray = generateIntArrayFromInputParams(params[3].toString());
		}
	}

	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 4;
	}
	
}
