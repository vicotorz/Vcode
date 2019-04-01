package WeBank;

import java.util.Scanner;

public class Main2 {
	public static void fun(int n) {
		// 小于等于n的回文数量
		int count = 0;
		for (int i = 0; i <= n; i++) {
			StringBuffer sb = new StringBuffer();
			int temp = i;
			while (temp != 0) {
				sb.append(temp & 1);
				temp = temp >> 1;
			}
			String reverse = sb.toString();
			sb = sb.reverse();
			if (reverse.equals(sb.toString())) {
				System.out.println(sb + "," + reverse);
				count++;
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.valueOf(sc.nextLine());
			fun(n);
		}
		sc.close();
	}

}
