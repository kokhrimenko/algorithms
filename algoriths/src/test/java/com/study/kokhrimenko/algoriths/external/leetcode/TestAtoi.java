package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestAtoi extends JUnitStory<TestAtoi.CaseDataItem>{

	public TestAtoi() {
		super(Atoi.class,  params -> new CaseDataItem(params));
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
	
	protected static final class CaseDataItem {
		String comment;
		String inputNumber;
		int expectedResult;

		public CaseDataItem(Object... params) {
			this.comment = params[0].toString();
			this.inputNumber = params[1].toString();
			this.expectedResult = Integer.parseInt(params[2].toString());
		}
	}

	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 3;
	}
	
}
