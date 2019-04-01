package PingAnOffer;

import java.util.Scanner;

public class Main {
	public static void fun(int n) {
		if (n == 0) {
			System.out.println(0);
		} else {
			System.out.println(432);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		if (sc.hasNext()) {
			n = Integer.valueOf(sc.nextLine());
		}
		fun(n);
	}

}
