package printing;

import java.util.stream.IntStream;

public class PrintoutStreams {

	public static void main(String[] args) {
		// add up numbers 1-10
		System.out.println(IntStream.rangeClosed(1, 10).sum());

		// add evem numbers 2-20
		System.out.println(IntStream
				.rangeClosed(1, 10)
				.map(x -> x * 2)
				.sum());

	}

}
