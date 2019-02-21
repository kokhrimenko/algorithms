package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;
import com.study.kokhrimenko.algoriths.infrastructure.TestCaseItemData;

public class TestZigZagConversation extends JUnitStory<TestZigZagConversation.CaseDataItem> {

	public TestZigZagConversation() {
		super(ZigZagConversion.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
	}

	@Override
	protected void execute(CaseDataItem tcData) {
		ZigZagConversion executor = new ZigZagConversion();
		String resultedString = executor.convert(tcData.inputString, tcData.rowNumber);
		assertEquals(tcData.expectedString, resultedString);
	}
	
	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 4;
	}
	
	protected static final class CaseDataItem implements TestCaseItemData {
		final String comment;
		final String inputString;
		final int rowNumber;
		final String expectedString;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;			

			this.inputString = params[0];
			this.rowNumber = Integer.parseInt(params[1]);
			this.expectedString = params[2];			
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