package WangyiOffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main1 {

	public static boolean fun(int[] num, int n) {
		if (n <= 0) {
			return false;
		}
		// 被4除的偶数要
		int matchnum = 0;
		int jishu = 0;
		for (int i = 0; i < n; i++) {
			if (num[i] % 4 == 0) {
				matchnum++;
			}
			if (num[i] % 2 != 0) {
				jishu++;
			}
		}
		int requiredNum;
		if (n == 1 || n == 2 || n == 3) {
			requiredNum = 1;
		} else {
			requiredNum = n / 2;
		}
		if (matchnum >= requiredNum) {
			return true;
		} else if (matchnum >= jishu) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = Integer.valueOf(sc.nextLine());
		ArrayList result = new ArrayList();
		for (int i = 0; i < count; i++) {
			int n = Integer.valueOf(sc.nextLine());
			String[] str = sc.nextLine().split(" ");
			int[] num = new int[n];
			for (int t = 0; t < n; t++) {
				num[t] = Integer.valueOf(str[t]);
			}
			result.add(fun(num, n));
		}
		Iterator it = result.iterator();
		while (it.hasNext()) {
			boolean flag = (boolean) it.next();
			if (flag) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		sc.close();

	}

}
