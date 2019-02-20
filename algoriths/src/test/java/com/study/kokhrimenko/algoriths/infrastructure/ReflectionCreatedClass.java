package com.study.kokhrimenko.algoriths.infrastructure;

public interface ReflectionCreatedClass<T> {

	int getAllowedCountOfConstructorArguments();
	
	T instanciate(Object... params);
	
}
