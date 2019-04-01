package TouTiao;
import java.util.Scanner;

public class jinritoutiao2 {
	public static int result = 0;

	// 0~n中第m个数
	public static int Num(int n, int m) {
		int cur = 1;
		for (int i = 0; i < m-1; i++) {
			// 先增位
			if (cur * 10 <= n) {
				cur *= 10; // 扩展位数
			} else {
				// 后缩位
				if (cur >= n) cur /= 10;  //防止越界，把越界的结果压缩
				cur += 1;
				while (cur % 10 == 0)
					cur /= 10; // 进位后先缩短位数。
			}
		}
		return cur;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int n = Integer.valueOf(str[0]);
		int m = Integer.valueOf(str[1]);
		System.out.println(Num(n, m));
	}

}
