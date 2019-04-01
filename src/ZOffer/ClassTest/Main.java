package ClassTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void fun(int n, String[] str) {
		if (n <= 0) {
			System.out.println(0);
			return;
		}
		if (n == 1) {
			System.out.println(1);
			return;
		}
		int count = 0;
		HashMap map = new HashMap<String, Integer>();
		for (String e : str) {
			if (Contains(e, map)) {
				continue;
			} else {
				map.put(new StringBuffer(e + e).toString(), e.length());
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean Contains(String e, HashMap<String, Integer> map) {
		boolean flag = false;
		Set set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (key.contains(e)) {
				if (map.get(key) == e.length()) {
					flag = true;
				}
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.valueOf(sc.nextLine());
			String[] str = new String[n];
			for (int i = 0; i < n; i++) {
				str[i] = sc.nextLine();
			}
			fun(n, str);

		}
		sc.close();

	}

}
