package WeBank;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	private static BigDecimal result;

	public static void fun(BigDecimal a, BigDecimal b, BigDecimal c) {
		BigDecimal base = new BigDecimal(2);

		result = base.pow(a.intValue()).add(base.pow(b.intValue())).subtract(base.pow(c.intValue()));
		
		// System.out.println(result);
		int count = 0;
		//int size = result
		System.out.println(result);
		//for (int i = 0; i < size; i++) {
		//	if (result.charAt(i) == '1') {
		//		count++;
		//	}
		//}
		System.out.println(count);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			BigDecimal a = new BigDecimal(str[0]);
			BigDecimal b = new BigDecimal(str[1]);
			BigDecimal c = new BigDecimal(str[2]);
			fun(a, b, c);
		}
		sc.close();
	}

}
