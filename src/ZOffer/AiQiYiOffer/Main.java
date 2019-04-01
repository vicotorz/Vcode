package AiQiYiOffer;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			String num1 = str[0];
			int f1 = Integer.valueOf(str[1]);
			String num2 = str[2];
			int f2 = Integer.valueOf(str[3]);

			StringBuffer result1 = new StringBuffer();
			StringBuffer result2 = new StringBuffer();
			for (int i = 0; i < f1; i++) {
				result1.append(num1);
			}
			for (int j = 0; j < f2; j++) {
				result2.append(num2);
			}
			double r1 = Double.valueOf(result1.toString().trim());
			double r2 = Double.valueOf(result2.toString().trim());
			if (r1 < r2) {
				System.out.println("Less");
			} else if (r1 == r2) {
				System.out.println("Equal");
			} else {
				System.out.println("Greater");
			}

		}
		sc.close();
	}

}
