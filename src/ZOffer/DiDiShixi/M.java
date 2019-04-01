package DiDiShixi;

import java.util.Arrays;

import java.util.Comparator;
import java.util.Scanner;

public class M {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[][] toys = new int[n][2];
			for (int i = 0; i < n; i++) {
				toys[i][0] = sc.nextInt();
				toys[i][1] = sc.nextInt();
			}
			//真不会。。。
			Arrays.sort(toys, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] == o2[0])
						return o1[1] <= o2[1] ? -1 : 1;
					return o1[0] <= o2[0] ? -1 : 1;
				}
			});
			// for (int i = 0; i < toys.length; i++) {
			// for (int j = 0; j < 2; j++) {
			// System.out.print(toys[i][j] + " ");
			// }
			// System.out.println();
			// }
			int count = 1;
			int i = 0, j = 1;
			while (j <= n - 1) {
				if (toys[j][0] > toys[i][0] && toys[j][1] > toys[i][1]) {
					count++;
					i = j;
				}
				j++;
			}
			System.out.println(count);
		}
	}
}