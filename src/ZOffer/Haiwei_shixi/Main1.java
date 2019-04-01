package Haiwei_shixi;

import java.util.Scanner;

public class Main1 {


	// 规律： A B C D E F
	// F B
	// CD EF 有关 前 CD换位 后EF换位
	// L R
	// AB EF 有关 左 AB换位 右EF换位
	// A C 逆时针 顺时针
	// AB CD 有关 逆 CD换位 顺AB换位
	public static void main(String[] args) {
		int[] AB;
		int[] CD;
		int[] EF;
		AB = new int[2];
		AB[0] = 1;
		AB[1] = 2;
		CD = new int[2];
		CD[0] = 3;
		CD[1] = 4;
		EF = new int[2];
		EF[0] = 5;
		EF[1] = 6;
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			int size = str.length();
			for (int i = 0; i < size; i++) {
				char op = str.charAt(i);
				System.out.println(op);
				switch (op) {
				case 'L':
					// 左 AB换位 AB EF
					int t = AB[0];
					AB[0] = AB[1];
					AB[1] = t;
					// 然后 AB EF 互换位置
					int t1 = AB[0];
					int t2 = AB[1];
					AB[0] = EF[0];
					AB[1] = EF[1];
					EF[0] = t1;
					EF[1] = t2;
					break;
				case 'R':
					// 右EF换位
					int r = EF[0];
					EF[0] = EF[1];
					EF[1] = r;
					// 然后 AB EF 互换位置
					int r1 = EF[0];
					int r2 = EF[1];
					EF[0] = AB[0];
					EF[1] = AB[1];
					AB[0] = r1;
					AB[1] = r2;
					break;
				case 'F':
					// CD换位
					int f = CD[0];
					CD[0] = CD[1];
					CD[1] = f;
					// 然后 AB EF 互换位置
					int f1 = CD[0];
					int f2 = CD[1];
					CD[0] = EF[0];
					CD[1] = EF[1];
					EF[0] = f1;
					EF[1] = f2;
					break;
				case 'B':
					// EF
					int b = EF[0];
					EF[0] = EF[1];
					EF[1] = b;

					int b1 = EF[0];
					int b2 = EF[1];
					EF[0] = CD[0];
					EF[1] = CD[1];
					CD[0] = b1;
					CD[1] = b2;
					break;
				case 'A':
					// CD
					int a = CD[0];
					CD[0] = CD[1];
					CD[1] = a;

					int a1 = CD[0];
					int a2 = CD[1];
					CD[0] = AB[0];
					CD[1] = AB[1];
					AB[0] = a1;
					AB[1] = a2;
					break;
				case 'C':
					// AB
					int c = AB[0];
					AB[0] = AB[1];
					AB[1] = c;

					int c1 = AB[0];
					int c2 = AB[1];
					AB[0] = CD[0];
					AB[1] = CD[1];
					CD[0] = c1;
					CD[1] = c2;
					break;
				}
			}
			for (int i1 = 0; i1 <= 1; i1++) {
				System.out.print(AB[i1]);
			}
			for (int i2 = 0; i2 <= 1; i2++) {
				System.out.print(CD[i2]);
			}
			for (int i3 = 0; i3 <= 1; i3++) {
				System.out.print(EF[i3]);
			}
		}
		
	}
}
