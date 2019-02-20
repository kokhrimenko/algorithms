package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.external.leetcode.AddTwoNumbers.ListNode;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;

public class TestAddTwoNumbers extends JUnitStory<TestAddTwoNumbers.CaseDataItem> {

	public TestAddTwoNumbers() {
		super(AddTwoNumbers.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
	}

	@Test
	public void testExecutionFromFileDS() throws Exception {
		markTestStart();
		for(CaseDataItem testCase : testedDataSet) {
			getLogger().debug("Execute test story: {}", testCase.comment);
			execute(testCase.firstNumberNode, testCase.secondNumberNode, testCase.resultedNode);
		}
		markTestEnd();
	}
	
	private void execute(ListNode firstNode, ListNode secondNode, ListNode expectedNode) {
		AddTwoNumbers executor = new AddTwoNumbers();
		ListNode resultedNode = executor.addTwoNumbers(firstNode, secondNode);
		assertEquals(expectedNode, resultedNode);
	}
	
	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 4;
	}
	
	protected static final class CaseDataItem {
		String comment;
		ListNode firstNumberNode;
		ListNode secondNumberNode;
		ListNode resultedNode;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;			

			this.firstNumberNode = CaseDataItem.generateListNodeFromArrayValue(generateIntArrayFromInputParams(params[0]));
			this.secondNumberNode = CaseDataItem.generateListNodeFromArrayValue(generateIntArrayFromInputParams(params[1]));
			this.resultedNode = CaseDataItem.generateListNodeFromArrayValue(generateIntArrayFromInputParams(params[2]));			
		}
		
		private static ListNode generateListNodeFromArrayValue(int[] values) {
			ListNode node,
				prevNode = null,
				resultedNode = null;
			for (int i = 0; i < values.length; i++) {
				node = new ListNode(values[i]);

				if (resultedNode == null) {
					resultedNode = node;
				}

				if (prevNode != null) {
					prevNode.next = node;
				}
				prevNode = node;
			}
			
			return resultedNode;
		}
	}
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
}