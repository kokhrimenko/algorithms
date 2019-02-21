package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;
import com.study.kokhrimenko.algoriths.infrastructure.TestCaseItemData;

public class TestLongestPalindromeInString extends JUnitStory<TestLongestPalindromeInString.CaseDataItem> {

	public TestLongestPalindromeInString() {
		super(LongestPalindromeInString.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
	}

	@Override
	protected void execute(CaseDataItem tcData) {
		LongestPalindromeInString executor = new LongestPalindromeInString();
		String resultedString = executor.longestPalindrome(tcData.inputString);
		assertEquals(tcData.expectedString, resultedString);
	}
	
	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 3;
	}
	
	protected static final class CaseDataItem implements TestCaseItemData {
		final String comment;
		final String inputString;
		final String expectedString;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;			

			this.inputString = params[0];
			this.expectedString = params[1];			
		}

		public String getComment() {
			return comment;
		}		
	}
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
}