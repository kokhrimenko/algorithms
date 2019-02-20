package com.study.kokhrimenko.algoriths.infrastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JUnitStory<T> {
	private static final String DS_FILENAME_EXTENSION = "txt";
	private static final String ITEMS_DELIMITER = ";";

	private Class<?> testClass;
	private final Logger logger;
	protected List<T> testedDataSet = new ArrayList<>();

	public JUnitStory(Class<?> testClass, Function<Object[], T> dataSourceCreator) {
		super();
		this.testClass = testClass;
		this.logger = LoggerFactory.getLogger(testClass);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(testClass
				.getResourceAsStream(String.format("%s.%s", testClass.getSimpleName(), DS_FILENAME_EXTENSION))))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] items = line.split(ITEMS_DELIMITER);
				if (items == null || items.length != getAllowedCountOfConstructorArguments()) {
					throw new IllegalArgumentException("File with test data contains some wrong data: " + line);
				}

				testedDataSet.add(dataSourceCreator.apply(items));
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("Something went wrong with DS file", e);
		}

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

	protected int getAllowedCountOfConstructorArguments() {
		throw new RuntimeException("Please override me in supclasses");
	}
}
