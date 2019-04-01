package WangYi;

import java.util.Scanner;

public class Main1 {

	public static int coutNum(int[] x, int n) {		
		// int minY = Integer.MAX_VALUE;
		int[] result = new int[n];
		for (int MoveCount = 0; MoveCount < n; MoveCount++) {
			int minX = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int tempx = 0;
				for (int j = x[0]; j < n; j++) {
					tempx += Math.abs(x[j] - i);
				}
				if (tempx < minX) {
					minX = tempx;
				}
			}
		}

		// for (int i = y[0]; i <= y[n-1]; i++) {
		// int tempy = 0;
		// for (int j = y[0]; j < n; j++) {
		// tempy += Math.abs(y[j] - i);
		// }
		// if (tempy < minY) {
		// minY = tempy;
		// }
		// }
		// System.out.println(minX+"--"+minY);
		// return minX + minY;
		//return minX;
		return 0;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.valueOf(sc.nextLine());
			String[] xx = sc.nextLine().split(" ");
			// String[] yy = sc.nextLine().split(" ");
			int[] x = new int[n];
			// int[] y = new int[n];
			for (int i = 0; i < n; i++) {
				x[i] = Integer.valueOf(xx[i]);
				// y[i] = Integer.valueOf(yy[i]);
			}
			// System.out.println(coutNum(x, y, n));
			System.out.println(coutNum(x, n));
		}
		sc.close();
	}
}
