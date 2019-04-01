package XunleiOffer;

import java.util.Scanner;

public class Main {

	public static int fun(int num) {
		// 2-5
		int result = 0;
		for (int i = 2; i <= 5; i++) {
			// i进制取余数
			int shang = 1;
			int yu = 0;
			int n = num;
			while (shang != 0 || yu != 0) {
				result += yu;
				shang = n / i;
				yu = n % i;
				n = shang;
			}
		}
		return result;

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
