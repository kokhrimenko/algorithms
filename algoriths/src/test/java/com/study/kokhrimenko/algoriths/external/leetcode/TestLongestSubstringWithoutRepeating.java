package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;
import com.study.kokhrimenko.algoriths.infrastructure.TestCaseItemData;

public class TestLongestSubstringWithoutRepeating extends JUnitStory<TestLongestSubstringWithoutRepeating.CaseDataItem>{

	public TestLongestSubstringWithoutRepeating() {
		super(LongestSubstringWithoutRepeating.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
	}

	@Override
	protected void execute(CaseDataItem tcData) {
		LongestSubstringWithoutRepeating executor = new LongestSubstringWithoutRepeating();
		int resultedPos = executor.lengthOfLongestSubstring(tcData.inputString);
		assertEquals(tcData.expectedPos, resultedPos);
	}
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
	
	protected static final class CaseDataItem implements TestCaseItemData {
		final String comment;
		final String inputString;
		final int expectedPos;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;
			this.inputString = params[0];
			this.expectedPos = Integer.parseInt(params[1]);
		}

		public String getComment() {
			return comment;
		}
	}

	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 3;
	}
	
}
