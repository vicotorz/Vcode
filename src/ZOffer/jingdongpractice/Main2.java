package jingdongpractice;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] l = line.split(" ");
			double number = Double.valueOf(l[0]);
			double num = Double.valueOf(l[1]);

			double sum = 0.0;
			for (int i = 1; i <= num; i++) {
				double temp = Math.pow(number, (1 / Math.pow(2, i - 1)));
				sum = sum + temp;
			}
			BigDecimal b = new BigDecimal(sum);
			double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out.println(f1);

		}
	}
}
