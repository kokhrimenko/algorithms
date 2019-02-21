package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;
import com.study.kokhrimenko.algoriths.infrastructure.TestCaseItemData;

public class TestTwoSums extends JUnitStory<TestTwoSums.CaseDataItem>{

	public TestTwoSums() {
		super(TwoSums.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
	}

	@Override
	protected void execute(CaseDataItem tcData) {
		TwoSums executor = new TwoSums();
		int[] resultedArray = executor.twoSum(tcData.inputArray, tcData.target);
		assertNotNull(resultedArray);
		assertEquals(tcData.expectedArray.length, resultedArray.length);
		for(int i=0; i<tcData.expectedArray.length; i++) {
			assertEquals(tcData.expectedArray[i], resultedArray[i]);
		}
	}
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
	
	protected static final class CaseDataItem implements TestCaseItemData {
		final String comment;
		final int[] inputArray;
		final int target;
		final int[] expectedArray;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;
			this.inputArray = generateIntArrayFromInputParams(params[0]);
			this.target = Integer.parseInt(params[1]);
			this.expectedArray = generateIntArrayFromInputParams(params[2]);
		}

		public String getComment() {
			return comment;
		}
	}

	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 4;
	}
	
}
