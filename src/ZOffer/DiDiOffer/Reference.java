package DiDiOffer;

import java.util.Scanner;

public class Reference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer n = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		String[] st = str.split(" ");
		int left = 0;
		int m = 0;

		for (int i = 0; i < st.length; i++) {
			if (Integer.parseInt(st[i]) == 0) {
				m++;
				left = i + 1;
				continue;
			}
			System.out.println("left:" + left + " i:" + i);
			// 一定找到==0的位置才有值
			// 从右面开始找j,k
			for (int j = left; j < i; j++) {
				int cur = 0;
				for (int k = j; k <= i; k++) {
					System.out.println(j + "," + k);
					cur ^= Integer.parseInt(st[k]);
				}
				if (cur == 0) {
					// 符合条件
					m++;
					left = i + 1;
					continue;
				}
			}
		}
		System.out.println(m);
	}
}
