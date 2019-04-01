package DiDiShixi;

import java.util.Scanner;

public class Main {
	public void Reverse(String[] s) {
		for (int i = 0; i < s.length; i++) {
			// 反转
			StringBuffer sb = new StringBuffer();
			for (int j = s[i].length() - 1; j >= 0; j--) {
				sb.append(s[i].charAt(j));
			}
			s[i] = sb.toString();
		}
		// 输出
		for (int t = 0; t < s.length - 1; t++) {
			System.out.print(s[t] + " ");
		}
		System.out.print(s[s.length - 1]);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			String[] s = str.split(" ");
			Main m = new Main();
			m.Reverse(s);
		}
	}

}
