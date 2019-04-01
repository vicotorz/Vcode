package Shunfeng;

import java.util.Scanner;

public class Reference {
	public static String solution(long n) {
		String val = Long.toBinaryString(n);
		StringBuffer result = new StringBuffer();
		for (int bit = 1; bit < val.length(); bit++) {
			if (val.charAt(bit) == '0')
				result.append("4");
			else
				result.append("7");
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = Integer.parseInt(scanner.nextLine());
		String val = solution(num);
		System.out.println(val);

	}
}
