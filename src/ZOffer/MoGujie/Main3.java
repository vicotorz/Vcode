package MoGujie;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	public static String fun(double[] price) {
		Arrays.sort(price);
		double result = 0.00;
		for (int i = 1; i < price.length; i = i + 2) {
			result += price[i];
		}
		BigDecimal b = new BigDecimal(result);
		double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(f1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			double[] num = new double[str.length];
			for (int i = 0; i < str.length; i++) {
				num[i] = Double.valueOf(str[i]);
			}
			System.out.println(fun(num));
		}
		sc.close();
	}

}
