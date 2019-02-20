package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestLongestSubstringWithoutRepeating extends JUnitStory<TestLongestSubstringWithoutRepeating.CaseDataItem>{

	public TestLongestSubstringWithoutRepeating() {
		super(LongestSubstringWithoutRepeating.class,  params -> new CaseDataItem(params));
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
	
	protected static final class CaseDataItem {
		String comment;
		String inputString;
		int expectedPos;

		public CaseDataItem(Object... params) {
			this.comment = params[0].toString();
			this.inputString = params[1].toString();
			this.expectedPos = Integer.parseInt(params[2].toString());
		}
	}

	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 3;
	}
	
}
