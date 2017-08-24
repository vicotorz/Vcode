package ZOffer;

import java.util.concurrent.CopyOnWriteArrayList;

public class NumberOfOne {
	public static int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(NumberOf1(1));

	   CopyOnWriteArrayList<Integer> cs;
	}
}
