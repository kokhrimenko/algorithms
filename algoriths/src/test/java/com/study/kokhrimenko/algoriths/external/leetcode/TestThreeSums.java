package com.study.kokhrimenko.algoriths.external.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory;
import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReaderFactory.FileType;
import com.study.kokhrimenko.algoriths.infrastructure.JUnitStory;
import com.study.kokhrimenko.algoriths.infrastructure.TestCaseItemData;

public class TestThreeSums extends JUnitStory<TestThreeSums.CaseDataItem>{
	private static final String PAIR_LIST_DELIMITER = "\\|";
	
	public TestThreeSums() {
		super(ThreeSums.class, (comment, params) -> new CaseDataItem(comment, params.toArray(new String[params.size()])));
	}

	@Override
	protected void execute(CaseDataItem tcData) {
		ThreeSums executor = new ThreeSums();
		List<List<Integer>> resultedList = executor.threeSum(tcData.inputArray);
		assertNotNull(resultedList);
		assertEquals(tcData.expectedResult.size(), resultedList.size());
		for(List<Integer> item: tcData.expectedResult) {
			assertTrue(resultedList.contains(item));
		}
	}
	
	@Override
	protected FileType getInputDCType() {
		return FileDataSourceReaderFactory.FileType.TXT;
	}
	
	protected static final class CaseDataItem implements TestCaseItemData {
		final String comment;
		final int[] inputArray;
		final List<List<Integer>> expectedResult;

		public CaseDataItem(String comment, String... params) {
			this.comment = comment;
			this.inputArray = generateIntArrayFromInputParams(params[0]);
			if(params[1] != null) {
				expectedResult = new ArrayList<>();
				String[] resArrays = params[1].split(PAIR_LIST_DELIMITER);
				for(int i=0; i<resArrays.length; i++) {
					expectedResult.add(Arrays.stream(resArrays[i].split(ARRAY_ITEM_DELIMITER))
							.map(item -> Integer.parseInt(item.trim()))
							.collect(Collectors.toList()));
				}
			} else {
				expectedResult = null;
			}
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
