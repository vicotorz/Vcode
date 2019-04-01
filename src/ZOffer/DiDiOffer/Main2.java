package DiDiOffer;

import java.util.Scanner;

public class Main2 {
	public static void fun(int n) {
		int[] result = new int[n];
		result[0] = 1;
		int t2 = 0, t3 = 0, t5 = 0, i;
		for (i = 1; i < n; i++) {
			result[i] = Math.min(result[t2] * 2, Math.min(result[t3] * 3, result[t5] * 5));
			if (result[i] == result[t2] * 2)
				t2++;
			if (result[i] == result[t3] * 3)
				t3++;
			if (result[i] == result[t5] * 5)
				t5++;
		}
		System.out.println(result[n - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = Integer.valueOf(sc.nextLine());
			fun(N);

		}
		sc.close();

	}

}
