package ZDaJiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void fun(int originNumber, ArrayList list) {
		Collections.sort(list);
		char[] original = String.valueOf(originNumber).toCharArray();
		int[] origin = new int[original.length];
		Set<Integer> set = new HashSet<Integer>();
		for (int u = 0; u < original.length; u++) {
			origin[u] = Integer.valueOf(String.valueOf(original[u]));
			set.add(Integer.valueOf(String.valueOf(original[u])));
		}

		// ArrayList templist = new ArrayList<Integer>();
		// for (int e : set) {
		// templist.add(e);
		// }
		// Collections.sort(templist);

		// 大的替换小的

		for (int i = list.size() - 1; i >= 0; i--) {
			for (int j = 0; j < origin.length; j++) {
				int beitihuan = (int) origin[j];
				int tihuan = (int) list.get(i);
				if (beitihuan < tihuan) {
					for (int t = 0; t < origin.length; t++) {
						if (origin[t] == beitihuan) {
							origin[t] = tihuan;
						}
					}
					break;
				}
			}
		}

		for (int e : origin) {
			System.out.print(e);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = Integer.valueOf(sc.nextLine());
		for (int y = 0; y < number; y++) {

			int originNumber = Integer.valueOf(sc.nextLine());
			ArrayList list = new ArrayList();
			for (int i = 0; i < 3; i++) {
				list.add(Integer.valueOf(sc.nextLine()));
			}
			fun(originNumber, list);

		}
	}

}
