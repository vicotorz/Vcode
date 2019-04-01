package eBay;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

//p‘=C(n,1)*1/n-C(n,2)*1/n(n-1)+C(n,3)*1/n(n-1)(n-2)-...+(-1)^(k+1)*C(n,k)*1/n(n-1)...(n-k+1)+...+(-1)^(n+1)*C(n,n)*1/n!
//=1-1/2!+1/3!-1/4!+1/5!.+(-1)^(k+1)*1/k!+...+(-1)^(n+1)*1/n!
public class Main2 {
	public static String fun(int n) {
		int flag = 0;
		double result = 1;
		double temp = 1;
		for (int i = 1; i <= n; i++) {
			temp = temp * i;
			if (flag == 1) {
				result = result + (1 / temp);
			} else {
				result = result + (-1) * (1 / temp);
			}
			flag = flag ^ 1;
		}
		result = 1 - result;
		BigDecimal bg = new BigDecimal(result);
		double f1 = bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		DecimalFormat df = new DecimalFormat("#0.0000");
		return df.format(f1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		System.out.println(fun(n));
		sc.close();
	}
}
