package com.study.kokhrimenko.algoriths.infrastructure;

import java.util.HashMap;
import java.util.Map;

import com.study.kokhrimenko.algoriths.infrastructure.impl.FileDataSourceReaderTXT;

public abstract class FileDataSourceReaderFactory {

	private static final Map<FileType, FileDataSourceReader> READERS = new HashMap<>();
	static {
		READERS.put(FileType.TXT, new FileDataSourceReaderTXT());
	}
	
	public static enum FileType {
		XML,
		TXT
	}
	
	public static final FileDataSourceReader getDataSourceReader(FileType fileType) {
		if(!READERS.containsKey(fileType)) {
			throw new IllegalArgumentException("Reader for provided fileType doesn't implemented at the moment!");
		}
		
		return READERS.get(fileType);
	}
	
}
