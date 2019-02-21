package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;
import com.study.kokhrimenko.algoriths.infrastructure.TestCaseItemData;

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
	
	@Override
	protected void execute(CaseDataItem tcData) {
		Atoi executor = new Atoi();
		int resultedValue = executor.myAtoi(tcData.inputNumber);
		assertEquals(tcData.expectedNumber, resultedValue);
	}
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
	
	protected static final class CaseDataItem implements TestCaseItemData {
		final String comment;
		final String inputNumber;
		final int expectedNumber;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;
			this.inputNumber = params[0];
			this.expectedNumber = Integer.parseInt(params[1]);
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
