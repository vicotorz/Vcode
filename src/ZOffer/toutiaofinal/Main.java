package toutiaofinal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static int judge(Set set, String word) {
		Iterator it = set.iterator();
		while (it.hasNext()) {
			String reg = it.next().toString();
			if (word.startsWith(reg)) {
				// System.out.println(word + "---" + reg);
				return 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Set<String> set = new HashSet();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m, n;
			String[] num = sc.nextLine().split(" ");
			m = Integer.valueOf(num[0]);
			n = Integer.valueOf(num[1]);
			for (int i = 0; i < m; i++) {
				set.add(sc.nextLine());
			}
			int[] result = new int[n];
			sc.nextLine();
			for (int j = 0; j < n; j++) {
				result[j] = judge(set, sc.nextLine());
			}
			for (int j = 0; j < n; j++) {
				System.out.println(result[j]);
			}
			sc.nextLine();
		}

	}

}
