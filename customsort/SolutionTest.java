package customsort;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import java.util.List;
import java.util.Arrays;

public class SolutionTest {
	
	public static void main(String args[]) {
		PrintStream stdout = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		List<Integer> input;

		boolean res;

		/*
		* Case 1: Input array contains one element.
		*/
		System.setOut(new PrintStream(os));

		input = Arrays.asList(1);
		Result.customSort(input);
		res = assertEquals("1\n", os.toString());

		System.setOut(stdout);
		os.reset();

		if(!res) {
			System.out.println("Failed test case 1");
		}

		/*
		* Case 2: Input array contains elements with different frequencies.
		*/
		System.setOut(new PrintStream(os));

		input = Arrays.asList(1, 2, 3, 4, 2, 3, 4, 3, 4, 4);
		Result.customSort(input);
		res = assertEquals("1\n2\n2\n3\n3\n3\n4\n4\n4\n4\n", os.toString());

		System.setOut(stdout);
		os.reset();

		if(!res) {
			System.out.println("Failed test case 2");
		}

		/*
		* Case 3: Input array contains elements with same frequencies.
		*/
		System.setOut(new PrintStream(os));

		input = Arrays.asList(1, 2, 3, 2, 3, 4);
		Result.customSort(input);
		res = assertEquals("1\n4\n2\n2\n3\n3\n", os.toString());

		System.setOut(stdout);
		os.reset();

		if(!res) {
			System.out.println("Failed test case 3");
		}
	}

	public static boolean assertEquals(String expected, String actual) {
		return expected.equals(actual);
	}
}