package Math;

import java.util.*;
import java.math.*;

public class BigNumber {
	public static void main(String agrs[]) {
		Scanner cin = new Scanner(System.in);
		BigInteger sum, temp;
		sum = BigInteger.ZERO;
		temp = cin.nextBigInteger();
		sum = temp;
		while (cin.hasNext()) {
			temp = cin.nextBigInteger();
			if (temp.equals(BigInteger.ZERO))
				break;
			sum = sum.add(temp);
		}
		System.out.println(sum);
	}
}