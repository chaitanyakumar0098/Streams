package com.epam;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class Streams {

	public static void main(String[] args) throws IOException {

		Collection<String> names = new ArrayList<String>();
		names.add("Rajender");
		names.add("Kiran");
		names.add("Aliance");
		names.add("Mahender");
		names.add("ShivaKumar");

		// to use multiple threads to process collection data using java 8
		List<String> parellel = names.parallelStream().collect(Collectors.toList());
		parellel.forEach(name -> System.out.println(name));

		// filter the collection data whose name having length >5 for this we can use
		// java 8 filter method which take predicate as argument
		List<String> listOfNames = names.stream().filter(name -> name.length() > 5).collect(Collectors.toList());
		listOfNames.forEach(name -> System.out.println(name));

		// everyname in the collection should be prefixed with Mr for this we can use
		// java 8 map method which take function as argument
		List<String> listOfPrifixNames = names.stream().map(name -> "Mr." + name).collect(Collectors.toList());
		System.out.println(listOfPrifixNames);

		// every name in the collection should be sorted for this we can use sorted
		// method in java 8
		List<String> listOfSortedNames = names.stream().sorted().collect(Collectors.toList());
		System.out.println(listOfSortedNames);

		Collection<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(30);
		numbers.add(20);
		numbers.add(50);
		numbers.add(40);

		// find max and min number from collection by using java 8
		int max = numbers.stream().max((n1, n2) -> n1.compareTo(n2)).get();
		int min = numbers.stream().min((n1, n2) -> n1.compareTo(n2)).get();
		System.out.println("Max Num::" + max + " Min Num::" + min);

		// reduce the all the elements in a collection to a single value for this we use
		// java 8 reduce method
		int num = numbers.stream().reduce(0, (n1, n2) -> n1 + n2).intValue();
		System.out.println(num);

		//Converting stream to array in java 8
		Integer[] array = numbers.stream().toArray(Integer[]::new);
		Stream.of(array).forEach(a -> System.out.println(a));
		
		//using optional in java 8
		Optional<Integer> possible = Optional.of(5);
		if(possible.isPresent()){
		    System.out.println(possible.get());
		}
		
		

	}

}
