package eBay;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main4 {
	public static void fun(BigDecimal[] num) {
		BigDecimal L = num[0];
		BigDecimal R = num[1];
		BigDecimal W = num[2];
		if (R.add(W).compareTo(L) > 0) {
			System.out.println("DEADLOCK");
		} else {
			System.out.println("OK");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		BigDecimal[] num = new BigDecimal[str.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = new BigDecimal(str[i]);
		}
		fun(num);
		sc.close();
	}
}
