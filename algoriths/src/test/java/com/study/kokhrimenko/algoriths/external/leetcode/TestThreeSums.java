package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;

public class TestThreeSums extends JUnitStory<TestThreeSums.CaseDataItem>{
	private static final String PAIR_LIST_DELIMITER = "\\|";
	
	public TestThreeSums() {
		super(ThreeSums.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
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
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
	
	protected static final class CaseDataItem {
		String comment;
		int[] inputArray;
		List<List<Integer>> expectedResult;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;
			this.inputArray = generateIntArrayFromInputParams(params[0]);
			if(params[1] != null) {
				expectedResult = new ArrayList<>();
				String[] resArrays = params[1].trim().split(PAIR_LIST_DELIMITER);
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
