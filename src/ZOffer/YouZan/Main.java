package YouZan;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static String fun(String str) {
		StringBuffer s = new StringBuffer();
		Stack s1 = new Stack<>();// 符号
		Stack s2 = new Stack<>();// 字母
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			System.out.println(s + "," + ch);
			if ((ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') && s1.isEmpty()) {
				System.out.println("1");
				s2.push(ch);
			} else if ((ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') && !s1.isEmpty()) {
				System.out.println("2");
				s2.push(ch);
				while (!s1.isEmpty()) {
					s.append(String.valueOf(s1.pop()));
				}
			} else if ((ch <= 'A' && ch >= 'Z' || ch <= 'a' && ch >= 'z') && s2.isEmpty()) {
				System.out.println("3");
				s1.push(ch);
			} else if ((ch <= 'A' && ch >= 'Z' || ch <= 'a' && ch >= 'z') && !s2.isEmpty()) {
				System.out.println("4");
				s1.push(ch);
				while (!s2.isEmpty()) {
					s.append(String.valueOf(s2.pop()));
				}
			}
		}
		System.out.println("wanshile" + s.toString());
		return s.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(fun(str));
	}

}
