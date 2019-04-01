package ZSouHu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static String fun(String str) {
		Set<String> set = new HashSet<String>();
		String result = null;
		for (int i = 0; i < str.length(); i++) {
			if (set.contains(String.valueOf(str.charAt(i)))) {
				result = String.valueOf(str.charAt(i));
				break;
			} else {
				set.add(String.valueOf(str.charAt(i)));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String str = sc.nextLine();
			System.out.println(fun(str));
		}
		sc.close();
	}

}
