package maxmoney;

public class SolutionTest {
	
	public static void main(String args[]) {
		boolean res;

		/*
		* Case 1: number of classmates = 1,
		* unlucky number = 1
		*/
		res = assertEquals(Solution.maxMoney(1, 1), 0);

		if(!res) {
			System.out.println("Failed test case 1");
		}

		/*
		* Case 2: number of classmates > 1,
		* unlucky number > 1,
		* unluck number not reached
		*/
		res = assertEquals(Solution.maxMoney(3, 5), 6);

		if(!res) {
			System.out.println("Failed test case 2");
		}

		/*
		* Case 3: number of classmates > 1,
		* unlucky number > 1,
		* unlucky number reached,
		* eligible sums = 1
		*/
		res = assertEquals(Solution.maxMoney(2, 1), 2);

		if(!res) {
			System.out.println("Failed test case 3");
		}

		/*
		* Case 4: number of classmates > 1,
		* unlucky number > 1,
		* unlucky number reached,
		* eligible sums > 1
		*/
		res = assertEquals(Solution.maxMoney(4, 6), 9);

		if(!res) {
			System.out.println("Failed test case 4");
		}
	}

	public static boolean assertEquals(int expected, int actual) {
		return (expected == actual);
	}
}