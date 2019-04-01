package DiDiShixi;

import java.util.Scanner;

//编程思路 
//
public class Main2 {

	public void Taowa(int[][] array, int number) {
		// 二维数组第一列排序，找第二列顺序最长的
		for (int i = 0; i < number; i++) {
			int temp1 = array[i][0];
			int temp2 = array[i][1];
			int loc = 0;
			for (int j = 0; j < number; j++) {
				if (array[j][0] < array[i][0]) {
					loc = j;
				}
			}
			array[i][0] = array[loc][0];
			array[i][1] = array[loc][1];
			array[loc][0] = temp1;
			array[loc][1] = temp2;
		}

		// 找第二列顺序数最大的
		int max = 0;
		for (int t = 0; t < number - 1; t++) {
			int tempmax = 0;
			for (int y = t + 1; y < number; y++) {
				if (array[t][1] < array[y][1]) {
					tempmax++;
				}
			}
			if (tempmax > max) {
				max = tempmax;
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = Integer.valueOf(sc.nextLine());
		int[][] lenwid = new int[number][2];
		int index = 0;
		// while (sc.hasNextLine()) {
		for (int y = 0; y < number; y++) {
			String str = sc.nextLine();
			String[] s = str.split(" ");

			int a = Integer.valueOf(s[0]);
			int b = Integer.valueOf(s[1]);
			lenwid[index][0] = a > b ? a : b;
			lenwid[index][1] = a > b ? b : a;
			index++;
			// }
		}
		Main2 m = new Main2();
		m.Taowa(lenwid, number);
		System.currentTimeMillis();

	}

}
