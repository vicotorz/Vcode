package Xiecheng;

import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
	public static String fun(String str) {
		StringBuffer sb = new StringBuffer();
		HashMap map = new HashMap();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.get(c) == null) {
				sb.append(c);
				map.put(c, 1);
			} else {
				continue;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(fun(str));
	}
}
