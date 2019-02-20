package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;

public class TestThreeSums extends JUnitStory<TestThreeSums.CaseDataItem>{
	private static final String PAIR_LIST_DELIMITER = "\\|";
	
	public TestThreeSums() {
		super(ThreeSums.class,  params -> new CaseDataItem(params));
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
		ThreeSums executor = new ThreeSums();
		List<List<Integer>> resultedList = executor.threeSum(inputItem.inputArray);
		assertNotNull(resultedList);
		assertEquals(inputItem.expectedResult.size(), resultedList.size());
		for(List<Integer> item: inputItem.expectedResult) {
			assertTrue(resultedList.contains(item));
		}
	}
	
	protected static final class CaseDataItem {
		String comment;
		int[] inputArray;
		List<List<Integer>> expectedResult;

		public CaseDataItem(Object... params) {
			this.comment = params[0].toString();
			this.inputArray = generateIntArrayFromInputParams(params[1].toString());
			if(params[2] != null) {
				expectedResult = new ArrayList<>();
				String[] resArrays = params[2].toString().trim().split(PAIR_LIST_DELIMITER);
				for(int i=0; i<resArrays.length; i++) {
					expectedResult.add(Arrays.stream(resArrays[i].trim().split(ARRAY_ITEM_DELIMITER))
							.map(item -> Integer.parseInt(item.trim()))
							.collect(Collectors.toList()));
				}
			};
		}
	}

	@Override
	protected int getAllowedCountOfConstructorArguments() {
		return 3;
	}
	
}
