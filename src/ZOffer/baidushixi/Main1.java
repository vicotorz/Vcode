package baidushixi;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int number = Integer.valueOf(sc.nextLine());
			String line = sc.nextLine();
			String[] ss = line.split(" ");
			double[] ii = new double[ss.length];
			for (int y = 0; y < ss.length; y++) {
				ii[y] = Double.valueOf(ss[y]);
			}

			// 计算至少得及格多少科目
			int passnumber = 0;
			double sum = 0;
			for (int p = 0; p < ss.length; p++) {
				sum = sum + ii[p];
			}
			// 重新分配
			for (int p1 = 0; p1 < ss.length; p1++) {
				BigDecimal a = new BigDecimal(ii[p1]);
				BigDecimal b = new BigDecimal(sum);
				ii[p1] = a.divide(b, 2, RoundingMode.HALF_UP).doubleValue();
			}
			for (int pp = 0; pp < ss.length; pp++) {
				System.out.println("[]"+ii[pp]);
			}

			double sum1 = 0;
			for (int p2 = 0; p2 < ss.length; p2++) {
				sum1 = sum1 + ii[p2];
				if (sum1 >= 0.6) {
							passnumber = p2+1;
					break;
				}
			}
			System.out.println(passnumber);
			double finsum = 0;
			for (int h = passnumber; h <= ss.length; h++) {
				finsum = finsum + cnk(h, ss.length);
			}
			finsum = finsum * Math.pow(ii[0], passnumber);
			// 需要通过passnumber个科目才能 通过考试
			BigDecimal b = new BigDecimal(finsum);
			double f1 = b.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out.println(f1);

		}

	}

	// 求组合
	public static int cnk(int n, int k) {
		int fenzi = 1;
		int fenmu = 1;
		for (int i = n - k + 1; i <= n; i++) {
			String s = Integer.toString(i);
			BigInteger stobig = new BigInteger(s);

			fenzi *= i;
		}
		for (int j = 1; j <= k; j++) {
			String ss = Integer.toString(j);
			BigInteger stobig2 = new BigInteger(ss);

			fenmu *= j;
		}
		int result = fenzi / fenmu;
		return result;
	}

}
