package ZOffer;

public class Solution {
	public static int Fibonacci(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;

		}

		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.print(Fibonacci(i) + ",");
		}
	}
}