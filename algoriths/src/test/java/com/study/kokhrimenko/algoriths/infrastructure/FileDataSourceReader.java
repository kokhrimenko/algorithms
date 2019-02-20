package com.study.kokhrimenko.algoriths.infrastructure;

import java.io.InputStream;
import java.util.List;

public interface FileDataSourceReader {
	
	List<DataSourceItem> readAll(InputStream is, int countOfMustHaveParameters);
	
	public class DataSourceItem {
		private final String comment;
		private final List<String> params;
				
		public DataSourceItem(String comment, List<String> params) {
			super();
			this.comment = comment;
			this.params = params;
		}

		public String getComment() {
			return comment;
		}
		public List<String> getParams() {
			return params;
		}		
	}
	
}
