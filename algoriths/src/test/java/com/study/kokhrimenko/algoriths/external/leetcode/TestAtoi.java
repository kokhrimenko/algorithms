package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestAtoi extends JUnitStory<TestAtoi.CaseDataItem>{

	public TestAtoi() {
		super(Atoi.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
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
		Atoi executor = new Atoi();
		int resultedValue = executor.myAtoi(inputItem.inputNumber);
		assertEquals(inputItem.expectedResult, resultedValue);
	}
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
	
	protected static final class CaseDataItem {
		String comment;
		String inputNumber;
		int expectedResult;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;
			this.inputNumber = params[0];
			this.expectedResult = Integer.parseInt(params[1]);
		}
	}

	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 3;
	}
	
}
