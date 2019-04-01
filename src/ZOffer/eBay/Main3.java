package eBay;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {

	// 某个数称为无倍数数当且仅当其他的数都不是它的倍数
	public void fun(BigDecimal[] num) {
		Arrays.sort(num, new MyComprator());
		BigDecimal n = num[0];
		boolean flag = true;
		for (int i = 1; i < num.length; i++) {
			if (num[i].divideAndRemainder(n)[1].compareTo(new BigDecimal(0)) > 0) {
				// 除不了
				flag = false;
				break;
			}
		}
		int start = 0;
		StringBuffer sb = new StringBuffer();
		if (flag) {
			// System.out.println(flag);
			for (int i = 0; i < num.length; i++) {
				if (num[i].compareTo(n) != 0) {
					start = i;
					break;
				} else if (i == num.length - 1) {
					start = i + 1;
					break;
				}
			}
		}
		// System.out.println(start);
		for (; start < num.length; start++) {
			sb.append(num[start] + " ");
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		} else {
			System.out.println(0);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		String[] line = sc.nextLine().split(" ");
		BigDecimal[] num = new BigDecimal[n];
		for (int i = 0; i < n; i++) {
			num[i] = new BigDecimal(line[i]);
		}
		new Main3().fun(num);
		sc.close();
	}

}

class MyComprator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return ((BigDecimal) o1).compareTo((BigDecimal) o2);
	}
}