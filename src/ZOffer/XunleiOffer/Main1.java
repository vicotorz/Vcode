package XunleiOffer;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main1 {

	public static String fun(int n) {
		BigDecimal result = new BigDecimal(2);
		return result.pow(n).toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.valueOf(sc.nextLine());
			System.out.println(fun(n));
		}
		sc.close();

	}

}
