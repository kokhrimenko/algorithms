package com.study.kokhrimenko.algoriths.external.oracle.jdk8;

import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FunctionalChallenge {

	public static void main(String[] args) {
		String starWars = "Luke DarVader ObiWan  QuiGonJinn Palpatine";
		
		Function<String, Stream<String>> lineSplitter = l ->  Pattern.compile(" ").splitAsStream(l);
		
		Stream.of(starWars)
			.flatMap(lineSplitter)
			.sorted((o1, o2) -> o2.compareTo(o1))
			.forEachOrdered(System.out::println);
	}
	
}
