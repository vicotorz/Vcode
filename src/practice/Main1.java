package practice;

import java.util.Scanner;

public class Main1 {
	public int solution(int x, int k) {
		int count = 0;
		int y = 1;
		boolean flag = true;
		while (flag) {

			int A = x + y;
			int B = x | y;
			if (A == B) {
				count++;
			}
			if (count == k) {
				break;
			}
			y++;
		}
		return y;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] s = line.split(" ");
		int x = Integer.valueOf(s[0]);
		int k = Integer.valueOf(s[1]);
		Main1 m = new Main1();
		System.out.println(m.solution(x, k));
	}

}
