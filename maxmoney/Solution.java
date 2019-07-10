package maxmoney;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.FileWriter;

import java.util.LinkedList;

public class Solution {
	// Complete the maxMoney function below.
	static int maxMoney(int n, long k) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int sum = 0;

		// Add all money
		for(int i = 1; i <= n; i++) {
			int input = i%((10^9)+7);
			sum += input;
			sum %= ((10^9)+7);
			list.add(input);

			/*
			* If total sum of money is equal to unlucky number, subtract the minimum
			* amount required (the first element in list) to still get max money sum
			*/
			if(sum == k) {
				int first = list.removeFirst();
				sum -= first;
			}
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		
		int n = Integer.parseInt(bufferedReader.readLine().trim());
		long k = Long.parseLong(bufferedReader.readLine().trim());

		int res = maxMoney(n, k);
		
		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();
		bufferedReader.close();
		bufferedWriter.close();
	}
}