package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.external.leetcode.AddTwoNumbers.ListNode;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestAddTwoNumbers extends JUnitStory<TestAddTwoNumbers.CaseDataItem> {

	public TestAddTwoNumbers() {
		super(AddTwoNumbers.class, params -> new CaseDataItem(params));
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

		public CaseDataItem(Object... params) {
			this.comment = params[0].toString();			

			this.firstNumberNode = CaseDataItem.generateListNodeFromArrayValue(generateIntArrayFromInputParams(params[1].toString()));
			this.secondNumberNode = CaseDataItem.generateListNodeFromArrayValue(generateIntArrayFromInputParams(params[2].toString()));
			this.resultedNode = CaseDataItem.generateListNodeFromArrayValue(generateIntArrayFromInputParams(params[3].toString()));			
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
}	
