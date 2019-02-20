package com.study.kokhrimenko.algoriths.infrastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReader.DataSourceItem;

public abstract class JUnitStory<T> {
	protected static final String ARRAY_ITEM_DELIMITER = ",";
	
	private static final String DS_FILENAME_EXTENSION = "txt";

	private Class<?> testClass;
	private final Logger logger;
	protected List<T> testedDataSet = new ArrayList<>();

	public JUnitStory(Class<?> testClass, BiFunction<String, List<String>, T> dataSourceCreator) {
		super();
		this.testClass = testClass;
		this.logger = LoggerFactory.getLogger(testClass);
		
		FileDataSourceReader dataReader = FileDataSourceReaderFactory.getDataSourceReader(getInputDCType());
		List<DataSourceItem> inputTCData = dataReader.readAll(
				testClass.getResourceAsStream(String.format("%s.%s", testClass.getSimpleName(), DS_FILENAME_EXTENSION)),
				getAllowedCountOfConstructorArguments());
		
		testedDataSet = inputTCData.stream()
							.map(item -> dataSourceCreator.apply(item.getComment(), item.getParams()))
							.collect(Collectors.toList());
		if (testedDataSet.isEmpty()) {
			throw new IllegalArgumentException("File with test data doesn't contains any data!");
		}
	}

	protected Logger getLogger() {
		return logger;
	}

	protected void markTestEnd() {
		getLogger().debug("End to execute {} test cases at: {}", testClass.getSimpleName(), new Date());
	}

	protected void markTestStart() {
		getLogger().debug("Start to execute {} test cases at: {}", testClass.getSimpleName(), new Date());
	}

	protected abstract int getAllowedCountOfConstructorArguments();
	
	protected static int[] generateIntArrayFromInputParams(String inputParam) {
		if (inputParam == null || inputParam.trim().isEmpty()) {
			return null;
		}
		
		return Arrays.stream(inputParam.trim().split(ARRAY_ITEM_DELIMITER))
				.map(item -> item.trim())
				.mapToInt(Integer::parseInt).toArray();
	}
	
	protected abstract FileDataSourceReaderFactory.FileType getInputDCType();
}
