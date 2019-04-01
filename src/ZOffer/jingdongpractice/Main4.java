package jingdongpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] n = line.split(" ");
			int[] num = new int[n.length];
			for (int i = 0; i < n.length; i++) {
				num[i] = Integer.valueOf(n[i]);
			}
			String[] set1 = sc.nextLine().split(" ");
			String[] set2 = sc.nextLine().split(" ");

			Set<Integer> s1 = new HashSet<Integer>();
			Set<Integer> s2 = new HashSet<Integer>();
			for (int i = 0; i < num[0]; i++) {
				s1.add(Integer.valueOf(set1[i]));
			}
			for (int i = 0; i < num[1]; i++) {
				s2.add(Integer.valueOf(set2[i]));
			}
			// 并集
			Set<Integer> result = new HashSet<Integer>();
			result.clear();
			result.addAll(s1);
			result.addAll(s2);

			List<Integer> list = new ArrayList<Integer>();
			list.addAll(result);
			Collections.sort(list);
			for (int i = 0; i < num[0] + num[1] - 1; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.print(list.get(list.size()-1));

		}
	}
}
