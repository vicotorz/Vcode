package JingDong;

import java.util.Scanner;

public class Main {

	public void find(int num, String line) {

		String[] str = new String[num];
		for (int i = 0; i < num; i++) {
			str[i] = line.valueOf(i);
		}
		int[][] mark = new int[num][num];
		// 初始化
		for (int t = 0; t < num; t++) {
			for (int y = 0; y < num; y++) {
				mark[t][y] = -1;
			}
		}

		for (int t = 0; t < num; t++) {
			// 如果查到警察，记录能检测的范围
			if (Integer.valueOf(str[t]) >= 1 || Integer.valueOf(str[t]) <= 1) {
				int pow = Integer.valueOf(str[t]);
				for (int y = 1; y <= pow; y++) {
					if (t - y >= 0) {
						mark[t][t - y] = 1;
					}

					if (t + y < num) {
						mark[t][t + y] = 1;
					}
				}

			}
		}

		// 遍历每个列，如果有两个1的标记，访问数组是小偷，则记录
		int totalnumber = 0;
		for (int yy = 0; yy < num; yy++) {
			int d = 0;
			for (int xx = 0; xx < num; xx++) {
				if (mark[xx][yy] == 1) {
					d++;
				}
			}
			if (d >= 2) {
				if (str[yy].equals("X")) {
					totalnumber++;
				}
			}
		}
		System.out.println(totalnumber);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int number = Integer.valueOf(sc.nextLine());
			String line = sc.nextLine();
			Main m = new Main();
			m.find(number, line);
		}

	}

}
