package MoniTest;

import java.util.Scanner;

public class Main {
	// 删除之后最长偶串
	public int maxString(String word) {
		if (word.length() < 2) {
			return 0;
		} else if (word.length() == 2) {
			if (word.substring(0, 1).equals(word.substring(1, 2))) {
				return 1;
			}
		} else {
			word = word.substring(0, word.length() - 1);
		}
		// System.out.println(word);

		// 从后往前，分割一半看是不是一样
		int max = 0;
		int size = word.length() - 1;
		int i = size;
		for (; i >= 1; i--) {
			int med = (size + 1) / 2;
			String str1 = word.substring(0, med);
			String str2 = word.substring(med, size + 1);
			// System.out.println("--"+str1);
			// System.out.println("--"+str2);
			if (str1.equals(str2)) {
				// System.out.println(med);
				// System.out.println(word);
				// System.out.println(str1);
				// System.out.println(str2);
				max = size + 1;
				break;
			} else {
				word = word.substring(0, i);
				// System.out.println("bian----"+word);
				size = word.length() - 1;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		System.out.println(word);
		if (word.equals("")) {
			System.out.println(0);
		} else {
			System.out.println(m.maxString(word));
			
		}

	}

}
