package filtering;

import java.util.stream.IntStream;

public class FilterExamples {

	public static void main(String[] args) {

		// Triple the even ints from 2 through 10 then sum them with IntStream.
		// sum the triples of the even integers from 2 through 10
		System.out.printf(
				"Sum of the triples of the even ints from 2 through 10 is: %d%n",
				IntStream.rangeClosed(1, 10) // numbers 1-10
				.filter(x -> x % 2 == 0) // only even ints have remainder of 0
				.map(x -> x * 3) // multiply each value of "x" by 3
				.sum()); // finally sum up all those values into a total

	}

}
