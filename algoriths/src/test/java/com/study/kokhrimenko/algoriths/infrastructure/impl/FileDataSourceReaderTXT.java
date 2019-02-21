package com.study.kokhrimenko.algoriths.infrastructure.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.study.kokhrimenko.algoriths.infrastructure.FileDataSourceReader;

public class FileDataSourceReaderTXT implements FileDataSourceReader{
	private static final String ITEMS_DELIMITER = ";";

	@Override
	public List<DataSourceItem> readAll(InputStream is, int countOfMustHaveParameters) {
		if(is == null) {
			return Collections.emptyList();
		}
		
		List<DataSourceItem> resuledDS = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line = "";			
			while ((line = br.readLine()) != null) {
				String[] items = line.split(ITEMS_DELIMITER);
				if (items == null || items.length != countOfMustHaveParameters) {
					throw new IllegalArgumentException("File with test data contains some wrong data: " + line);
				}

				items = Arrays.stream(items)
								.map(item -> item != null ? item.trim() : item)
								.toArray(size -> new String[size]);
				resuledDS.add(new DataSourceItem(items[0], Arrays.asList(Arrays.copyOfRange(items, 1, items.length))));
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("Something went wrong with DS file", e);
		}
		return resuledDS;

	}

}
