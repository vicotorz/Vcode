package moneypractice;

import java.util.Scanner;

public class practice {

	/**
	 * 2014.8.28 关于找钱问题的思路实现验证
	 * 
	 * 问题： 店员这假设有0.1元，0.5元，1元，2元，5元和10元（但是每个面额的钱数不定）
	 * 
	 * 假设顾客给店员的钱在0~100元以内，设计程序找给钱
	 * 
	 * 
	 * 思路：找最大的钱，然后有点像递归分治那样，一点点对当前的钱数进行找钱
	 * 
	 * 
	 * 出现的问题：
	 * 
	 * 这里会出现浮点数的问题，尤其是定义0.1元和0.5元时会出现浮点数看不懂的情况，因此需要将这里的钱数都转为大于1，再进行
	 * 
	 * 
	 */
	practice() {
	}

	double moneyname[] = { 1.0, 5.0, 10.0, 20.0, 50.0, 100.0 };// 钱数

	int moneynumber[] = { 1, 2, 3, 1, 1, 6 };// 钱的个数

	int usernumber[] = new int[6];// 这样声明数组

	public void cleararray(int usernumber[]) {

		for (int i = 0; i < usernumber.length - 1; i++) {
			if (usernumber[i] != 0) {
				usernumber[i] = 0;
			}
		}
	}

	// 得到具体的位置
	public int getlocation(double sum) {
		int i = 0;
		for (; i < 5; i++) {
			if (moneyname[i] == sum) {
				break;
			} else if (moneyname[i] < sum && moneyname[i + 1] > sum) {
				break;
			}
		}
		return i;

	}

	public boolean changefunction(double summoney) {
		cleararray(usernumber);
		double sum = summoney;

		if (sum <= 0) {

			return false;
		}

		// 当钱大于零或者零钱数还够进行找钱时，进行
		while (sum > 0) {

			// 跳出的条件是----当sum>0且moneynumber[0]=0时，就可以确定是不能找钱的了
			int lestloc = getlocation(sum);
			/*
			 * System.out.println("sum值为" + sum); System.out.println("lestloc值为"
			 * + lestloc); System.out.println("要找的最大位置钱名为" +
			 * moneyname[lestloc]); System.out.println("要找的最大位置钱个数为" +
			 * moneynumber[lestloc]);
			 */
			// 找lestloc位置的钱的个数

			if (moneynumber[lestloc] != 0) {
				// 当在应该找的最大位置有钱时
				sum = sum - moneyname[lestloc];
				moneynumber[lestloc] = moneynumber[lestloc] - 1;
				usernumber[lestloc] = usernumber[lestloc] + 1;

			} else {
				// 如果正确的最大位置没有钱，那么这个位置就要换到次大且有钱的位置
				while (moneynumber[lestloc] <= 0) {
					if (lestloc <= 0) {
						// 结束了
						return false;
					} else {
						lestloc -= 1;
					}
				}

				sum = sum - moneyname[lestloc];
				moneynumber[lestloc] = moneynumber[lestloc] - 1;
				usernumber[lestloc] += 1;
			}

		}
		return true;

	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("请输入钱数");
			Scanner scan = new Scanner(System.in);
			double money = (double) scan.nextDouble();
			practice pra = new practice();
			if (pra.changefunction(money * 10)) {
				System.out.println("找钱情况为");
				System.out.println("-------------------");
				for (int r = 0; r < 6; r++) {
					if (pra.usernumber[r] > 0) {
						if (pra.moneyname[r] < 10) {
							System.out.println(pra.moneyname[r] / 10 + "元："
									+ pra.usernumber[r]);
						} else {
							System.out.println(pra.moneyname[r] + "元："
									+ pra.usernumber[r]);
						}

					}

				}
				System.out.println("-------------------");
			} else {
				System.out.println("-------------------");
				System.out.println("不能找钱！");
				System.out.println("-------------------");
			}

		}
	}
}
