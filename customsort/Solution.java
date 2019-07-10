package customsort;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;


class Result {
	/*
	* Complete the 'customSort' function below.
	* The function accepts INTEGER_ARRAY arr as parameter.
	*/
	public static void customSort(List<Integer> arr) {
		/*
		* Create a hashmap containing the unique elements in input array as key,
		* and their corresponding frequency as value.
		*/
		HashMap<Integer, Integer> input = new HashMap<Integer, Integer>();
		ListIterator<Integer> li = arr.listIterator();

		for(Integer entry : arr) {
			int count = input.containsKey(entry) ? input.get(entry) : 0;
			input.put(entry, count + 1);
		}

		// Create a list containing the elements in hashmap.
		List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer, Integer> >(input.entrySet());

		/*
		* Sort the list.
		* Use a custom comparator to sort by value(frequency), then by key(value).
		*/
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
			public int compare(Map.Entry<Integer, Integer> v1, Map.Entry<Integer, Integer> v2) {
				if(v1.getValue() == v2.getValue()) {
					return v1.getKey() - v2.getKey();
				} else {
					return v1.getValue() - v2.getValue();
				}
			}
		});

		// Use sorted list to create sorted hashmap
		HashMap<Integer, Integer> sorted = new LinkedHashMap<Integer, Integer>();

		for(Map.Entry<Integer, Integer> entry : list) {
			sorted.put(entry.getKey(), entry.getValue());
		}

		// Print sorted hashmap
		for(Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
			for(int i = 0; i < entry.getValue(); i++) {
				System.out.println(entry.getKey());
			}
		}

	}
}

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
		List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	
		Result.customSort(arr);
		bufferedReader.close();
	}

}