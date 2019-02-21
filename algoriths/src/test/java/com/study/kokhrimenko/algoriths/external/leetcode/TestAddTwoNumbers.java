package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;

import com.study.kokhrimenko.algoriths.external.leetcode.AddTwoNumbers.ListNode;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;
import com.study.kokhrimenko.algoriths.infrastructure.TestCaseItemData;

public class TestAddTwoNumbers extends JUnitStory<TestAddTwoNumbers.CaseDataItem> {

	public TestAddTwoNumbers() {
		super(AddTwoNumbers.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
	}

	@Override
	protected void execute(CaseDataItem tcData) {
		AddTwoNumbers executor = new AddTwoNumbers();
		ListNode resultedNode = executor.addTwoNumbers(tcData.firstNumberNode, tcData.secondNumberNode);
		assertEquals(tcData.expecedNode, resultedNode);
	}
	
	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 4;
	}
	
	protected static final class CaseDataItem implements TestCaseItemData {
		final String comment;
		final ListNode firstNumberNode;
		final ListNode secondNumberNode;
		final ListNode expecedNode;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;			

			this.firstNumberNode = CaseDataItem.generateListNodeFromArrayValue(generateIntArrayFromInputParams(params[0]));
			this.secondNumberNode = CaseDataItem.generateListNodeFromArrayValue(generateIntArrayFromInputParams(params[1]));
			this.expecedNode = CaseDataItem.generateListNodeFromArrayValue(generateIntArrayFromInputParams(params[2]));			
		}
				
		public String getComment() {
			return comment;
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