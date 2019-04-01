package CuBao;

import java.util.ArrayList;
import java.util.Scanner;

//光棍指数--区间中1最多，且最小的数
public class Main {
	public static int fun(int low, int high) {
		// 计算最大位数
		int temp = high;
		int MAX = 0;
		while (temp != 0) {
			MAX++;
			temp = temp >> 1;
		}
		int result = 0;
		int i = 0;
		if (low % 2 == 0) {
			i = low + 1;
		} else {
			i = low;
		}
		// System.out.println(MAX);
		int k = 1;
		for (; i <= high && k < MAX - 1; i = i + 2, k++) {
		}
		int god = 0;
		if (k == MAX - 1) {
			god = k;
		} else {
			god = i;
		}
		if (low != 0) {
			result = low;
		} else {
			result = 0;
		}
		 //System.out.println(god + "," + max + "," + k);
		for (int t = 0; t < god; t++) {
			result += 1;
		}
		return result;
	}

	public static int level(int num) {
		int t = num;
		int level = 0;
		while (t != 0) {
			if ((t & 1) == 1) {
				level++;
			}
			t = t >> 1;
		}
		return level;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			list.add(fun(Integer.valueOf(str[0]), Integer.valueOf(str[1])));
		}
		for (int y = 1; y <= list.size(); y++) {
			System.out.println("Case " + y + ": " + list.get(y - 1));
		}
		sc.close();
	}
	// int highCount = 0;
	// int result = 0;
	// int temp = high;
	// while (temp != 0) {
	// temp = temp >> 1;
	// highCount++;
	// }
	// highCount--;
	// // System.out.println(highCount);
	// for (int t = 0; t < highCount; t++) {
	// result += Math.pow(2, t);
	// }
	// // System.out.println(result);
	// return result;
}
