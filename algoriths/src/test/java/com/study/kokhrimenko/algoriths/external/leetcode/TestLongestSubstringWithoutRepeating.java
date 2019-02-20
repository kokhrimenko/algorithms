package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestLongestSubstringWithoutRepeating extends JUnitStory<TestLongestSubstringWithoutRepeating.CaseDataItem>{

	public TestLongestSubstringWithoutRepeating() {
		super(LongestSubstringWithoutRepeating.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
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
		LongestSubstringWithoutRepeating executor = new LongestSubstringWithoutRepeating();
		int resultedPos = executor.lengthOfLongestSubstring(inputItem.inputString);
		assertEquals(inputItem.expectedPos, resultedPos);
	}
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
	
	protected static final class CaseDataItem {
		String comment;
		String inputString;
		int expectedPos;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;
			this.inputString = params[0];
			this.expectedPos = Integer.parseInt(params[1]);
		}
	}

	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 3;
	}
	
}
