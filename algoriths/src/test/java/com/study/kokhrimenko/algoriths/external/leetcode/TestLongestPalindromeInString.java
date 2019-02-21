package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestLongestPalindromeInString extends JUnitStory<TestLongestPalindromeInString.CaseDataItem> {

	public TestLongestPalindromeInString() {
		super(LongestPalindromeInString.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
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
	
	private void execute(CaseDataItem testCaseData) {
		LongestPalindromeInString executor = new LongestPalindromeInString();
		String resultedString = executor.longestPalindrome(testCaseData.inputString);
		assertEquals(testCaseData.expectedString, resultedString);
	}
	
	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 3;
	}
	
	protected static final class CaseDataItem {
		String comment;
		String inputString;
		String expectedString;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;			

			this.inputString = params[0].trim();
			this.expectedString = params[1].trim();			
		}
	}
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
}