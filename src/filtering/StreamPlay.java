package filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPlay {
	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1,2,4,6,8,9,88);
		Stream<Integer> st = values.stream();
		st.filter(f -> f > 4).forEach(System.out::println);

		List<String> stuff = Arrays.asList("apple", "banana", "orange", "pinapple", "strawberry");
		stuff.stream()
				.filter( str -> str.contains("ap") || str.contains("r"))
				.forEach(System.out::println);


		List<Integer> int_values = Arrays.asList(1, 2, 4, 6, 8, 9, 88);

		// square each value and collect results into "mod" list
		List<Integer> mod = int_values.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(mod);

		List<String> fooList = Arrays.asList("goo", "boo", "poo", "too", "foo", "bar", "baz", "aoo", "gato");
		List<String> result = fooList.stream()
				.filter(s -> s.contains("g") || s.contains("a") || s.contains("t"))
				.map(String::toUpperCase)
				.limit(3)
				.collect(Collectors.toList());

		System.out.println(result.toString());
	}

}
