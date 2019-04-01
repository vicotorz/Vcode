package ClassTest;

import java.util.Scanner;

public class Main3 {

	public static void fun(int n, String[] str) {
		if (n == 1) {
			System.out.println(str[0]);
			return;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = n - 1; i >= 0; i = i - 2) {
			sb.append(str[i]+" ");
		}
		//System.out.println(sb.toString());
		for (int t = n % 2 == 0 ? 0 : 1; t < n; t = t + 2) {
			sb.append(str[t]+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.valueOf(sc.nextLine());
			String[] str = sc.nextLine().split(" ");
			fun(n, str);
		}
		sc.close();

	}

}
