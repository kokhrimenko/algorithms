package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestZigZagConversation extends JUnitStory<TestZigZagConversation.CaseDataItem> {

	public TestZigZagConversation() {
		super(ZigZagConversion.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
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
		ZigZagConversion executor = new ZigZagConversion();
		String resultedString = executor.convert(testCaseData.inputString, testCaseData.rowNumber);
		assertEquals(testCaseData.expectedString, resultedString);
	}
	
	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 4;
	}
	
	protected static final class CaseDataItem {
		String comment;
		String inputString;
		int rowNumber;
		String expectedString;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;			

			this.inputString = params[0].trim();
			this.rowNumber = Integer.parseInt(params[1]);
			this.expectedString = params[2].trim();			
		}
	}
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
}