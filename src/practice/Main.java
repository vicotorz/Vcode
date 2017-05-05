package practice;

import java.util.Scanner;

public class Main {
	public String deal(String str, int begin, int end) {
		System.out.println(str);
		StringBuffer sb = new StringBuffer(str);
		StringBuffer s = new StringBuffer();
		for (int i = begin + end - 1; i >= begin; i--) {
			s.append(str.charAt(i));
		}
		// 原来位置的正后方
		sb.insert(begin + end, s);
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static void main(String[] args) {
		Main m = new Main();
		// TODO Auto-generated constructor stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int number = Integer.valueOf(sc.nextLine());
		for (int i = 0; i < number; i++) {
			String line = sc.nextLine();
			String[] s = line.split(" ");
			int start = Integer.valueOf(s[0]);
			int end = Integer.valueOf(s[1]);
			str = m.deal(str, start, end);
		}
		System.out.println(str);
	}

}
