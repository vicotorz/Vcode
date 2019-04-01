package MoGujie;

import java.util.Scanner;

public class Main {

	public static int fun(int year, int month, int day) {
		int result = day;
		int[] standard = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (year % 4 == 0) {
			standard[1] = 29;
		}

		for (int i = month - 2; i >= 0; i--) {
			result += standard[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			int[] num = new int[3];
			for (int i = 0; i < str.length; i++) {
				num[i] = Integer.valueOf(str[i]);
			}
			System.out.println(fun(num[0], num[1], num[2]));

		}
		sc.close();

	}

}
