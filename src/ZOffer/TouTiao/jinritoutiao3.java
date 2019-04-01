package TouTiao;
import java.util.Scanner;

public class jinritoutiao3 {
	public static int maxNum(int[] number, int n, int m) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if ((number[i] ^ number[j]) > m) {
					result += 1;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int n = Integer.valueOf(str[0]);
		int m = Integer.valueOf(str[1]);
		String[] st = sc.nextLine().split(" ");
		int[] number = new int[n];
		for (int i = 0; i < n; i++) {
			number[i] = Integer.valueOf(st[i]);
		}
		System.out.println(maxNum(number, n, m));
	}

}
