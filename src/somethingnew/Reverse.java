package somethingnew;

public class Reverse {

	/**
	 * 2014.9.29晚上写
	 * 
	 * 作者：Victorz
	 */

	// 反转函数
	public void Reversetest(int result[], int n, int loc) {
		if (n >= 10) {
			System.out.println(n);
			System.out.println(n / 10);
			Reversetest(result, n / 10, loc + 1);
		}
		System.out.println("------");
		System.out.println(n);
		System.out.println(n % 10);
		result[loc] = n % 10;

	}

	public static void main(String[] args) {

		int number = 123456789;
		int result[] = new int[9];// 数组这样定义

		Reverse r = new Reverse();
		r.Reversetest(result, number, 0);

		System.out.println("------输出---------");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}

	}

}
