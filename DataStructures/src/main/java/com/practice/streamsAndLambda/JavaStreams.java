package com.practice.streamsAndLambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args) throws IOException {

		// 1) Will print 1 to 9
		IntStream.range(1, 10)
			.forEach(System.out::print);

		System.out.println(); // just to have a blank line

		// 2) Will skip first 5 elements and print 6 to 9
		IntStream.range(1, 10)
			.skip(5)
			.forEach(x -> System.out.println(x));	// You can also do: .forEach(System.out::println);

		System.out.println();

		// 3) Should print sum of numbers 1 to 4
		System.out.println(IntStream.range(1, 5)
				.sum());

		System.out.println();

		// 4) Stream.of, sorted and findFirst. You can stream any primitives or objects
		// with Stream.of
		Stream.of("Ava", "Aneri", "Alberto")
			.sorted()
			.findFirst()
			.ifPresent(System.out::println);

		System.out.println();

		// 5) Stream from Arrays, sort, filter and print
		String[] names = 
			{ "Al", "Ankit", "Kushal", "Sarah", "Brent", "Sarika", "Amanda", "Hans", "Shivika" };
		Arrays.stream(names)
			.filter(x -> x.startsWith("S"))
			.forEach(System.out::println);

		System.out.println();

		// 6) Average of squares of int array
		Arrays.stream(new int[] { 2, 4, 6, 8, 10 })
			.map(x -> x * x)
			.average()
			.ifPresent(System.out::println);

		System.out.println();

		// 7) Stream from List, map, filter and print
		List<String> people = 
				Arrays.asList("Al", "Ankit", "Kushal", "Sarah", "Brent", "Sarika", "Amanda", "Hans",
				"Shivika");
		people.stream()
			.map(String::toLowerCase)	// You do this as .map(<Class Name>::<function name>)
			.filter(x -> x.startsWith("a"))
			.forEach(System.out::println);
		
		System.out.println();
		
		// 8) Stream rows from a text file, sort, filter and print
		Stream<String> bands = Files.lines(Paths.get("DataStructures/src/main/resources/bands.txt"));
		bands
			.sorted()
			.filter(x -> x.length() > 30)
			.forEach(System.out::println);
		bands.close();
		
		System.out.println();
		
		/**
		 * Note, to use right path with Paths.get method above it helps if we know our 
		 * current working directory. Below line prints that:
		 * 
		 * System.out.println(System.getProperty("user.dir"));
		 * 
		 * In this case, current working directory is: 
		 * /Users/ashesh/Documents/workspace-sts-3.9.6.RELEASE/DataStructures
		 * So I used the path of bands.txt as: src/main/resources/bands.txt above.

		 */
		
		// 9) Stream rows from text files and save to list
		List<String> bands2 = Files.lines(Paths.get("DataStructures/src/main/resources/bands.txt"))
				.filter(x -> x.contains("Fire"))
				.collect(Collectors.toList());
		bands2.forEach(System.out::println);
		System.out.println();
		
		// 10) Stream rows from CSV file, process it and count the results
		Stream<String> rows = Files.lines(Paths.get("DataStructures/src/main/resources/data.txt"));
		int rowCount = (int) rows
				.map(x -> x.split(","))
				.filter(x -> x.length >= 3)
				.count();
		System.out.println("Row Count with more than 3 elements = " + rowCount);
		rows.close();
		System.out.println();
		
		// 11. Stream rows from CSF file, parse data from rows and print
		Stream<String> rows1 = Files.lines(Paths.get("DataStructures/src/main/resources/data.txt"));
		rows1.map(x -> x.split(","))
			.filter(x -> x.length == 3)
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
		rows1.close();
		System.out.println();
		
		// 12. Stream rows from CSV file, process, filter, collect in a map and then print
		Stream<String> rows2 = Files.lines(Paths.get("DataStructures/src/main/resources/data.txt"));
		Map<String, Integer> map1 = new HashMap<>();
		map1 = rows2
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(
						x -> x[0],
						x -> Integer.parseInt(x[1])));
		rows2.close();
		map1.forEach((key, value) -> System.out.println(key + " " + value));
		System.out.println();
		
		// 13. Reduction - sum. Little hard to learn and remember it!
		// in .reduce function, 0.0 is starting total, a is running total and b is 
		// new item getting in which will be added to running total a.
		double total = Stream.of(7.3, 1.5, 4.8)
				.reduce(0.0, (Double a, Double b) -> a+b);
		System.out.println("Total: " + total);
		System.out.println();
		
		// 14. Reduction - summary statistics of integer data streams. Gives nice summary of data
		IntSummaryStatistics summary1 = IntStream.of(7, 2, 19, 88, 73, 4, 10)
				.summaryStatistics();
		System.out.println(summary1);
		System.out.println();
		
		// 15. Reduction - summary statistics of decimal data streams
		DoubleSummaryStatistics summary2 
			= DoubleStream.of(7.22, 2.11, 19.34, 88.05, 73.29, 4.0, 10.56)
				.summaryStatistics();
		System.out.println(summary2);
		System.out.println();






	}

}
