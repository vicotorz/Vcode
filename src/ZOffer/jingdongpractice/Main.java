package jingdongpractice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public boolean judge(int sumx, int sumy) {
		if (sumx == 3 && (sumy == 0 || sumy == 3)) {
			return true;
		} else if (sumx == 0 && sumy == 3) {
			return true;
		} else {
			return false;
		}
	}

	public void output(ArrayList<String> list) {
		// 判断x和 o 如果横坐标相同 纵坐标相同 y=x 或 x+y=2 则为胜出
		int sumxx = 0, sumxy = 0;
		int sumox = 0, sumoy = 0;
		for (int i = 0; i < list.size(); i++) {
			String line = list.get(i);
			for (int index = 0; index < 3; index++) {
				// System.out.println(i + "^^^" + index);
				if (line.charAt(index) == 'X') {
					// System.out.println("X");
					sumxx = sumxx + i;
					sumxy = sumxy + index;
				}
				if (line.charAt(index) == '0') {
					// System.out.println("0");
					sumox = sumox + i;
					sumoy = sumoy + index;
				}

				// System.out.println(line.charAt(index) + "-" + sumxx + "-"
				// + sumxy + "-" + sumox + "-" + sumoy);
			}
		}
		boolean x, o;
		// System.out.println(sumxx + "-" + sumxy + "-" + sumox + "-" + sumoy);
		x = judge(sumxx, sumxy);
		o = judge(sumox, sumoy);
		if (x) {
			System.out.println("1 won");
		} else if (o) {
			System.out.println("2 won");
		} else {
			System.out.println("draw");
		}
	}

	public static void main(String[] args) {
		Main m = new Main();

		Scanner sc = new Scanner(System.in);
		int i = 0;
		ArrayList<String> list = new ArrayList<String>();
		while (sc.hasNext()) {
			if (i % 3 == 0) {
				if (i != 0) {
					m.output(list);
				}
				list.clear();
				list.add(sc.nextLine());
				i++;
			} else {
				list.add(sc.nextLine());
				i++;

			}
		}
		// list.add("X0X");
		// list.add(".0.");
		// list.add(".X.");
		m.output(list);

	}
}
