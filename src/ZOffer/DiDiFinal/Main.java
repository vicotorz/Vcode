package DiDiFinal;

import java.util.Scanner;

public class Main {
	public static int NumMax(int[] num) {
		if (num == null) {
			return 0;
		}

		int[] tempmax = new int[num.length];
		int max = num[0];
		tempmax[0] = num[0];
		for (int i = 1; i < num.length; i++) {
			tempmax[i] = Math.max(num[i], tempmax[i - 1] + num[i]);
			if (tempmax[i] > max) {
				max = tempmax[i];
			}
		}
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] line = sc.nextLine().split(" ");
			int[] num = new int[line.length];
			for (int i = 0; i < line.length; i++) {
				num[i] = Integer.valueOf(line[i]);
			}

			System.out.println(NumMax(num));

		}
		sc.close();

	}

}
