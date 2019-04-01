package Paypal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
	public int location(String[] A, String key) {
		int location = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i].equals(key)) {
				location = i;
				break;
			}

		}
		return location;
	}

	// 查找并输出
	public void maxnum(int[] A, String[] original) {
		int max = 0;
		int tempmax;
		int tempmaxnum = 0;
		int base;
		// 记录路径
		StringBuffer sf = new StringBuffer();
		ArrayList<String> list = new ArrayList();

		for (int i = 0; i < A.length - 1; i++) {
			tempmaxnum = 0;
			tempmax = A[i];
			base = A[i];
			sf.append(base);
			System.out.println("[base]" + base);
			for (int j = i + 1; j < A.length; j++) {

				if (A[j] > tempmax) {
					tempmax = A[j];
					tempmaxnum++;
					sf.append(A[j]);
					System.out.println(A[j]);
				}
			}

			if (tempmaxnum >= max) {
				System.out.println("zhaodaole");
				max = tempmaxnum;
				String str = sf.toString();
				list.add(str);

			}
			sf.delete(0, sf.length());
		}
		// System.out.println("[max]" + max);
		int powernum = 100;
		String finsequence = null;
		for (String s : list) {
			if (Integer.valueOf(String.valueOf(s.charAt(0))) < powernum
					&& s.length() - 1 == max) {
				powernum = Integer.valueOf(String.valueOf(s.charAt(0)));
				finsequence = s;
			}
			System.out.println("))" + s);
		}
		System.out.println(max);
		for (int t = 0; t < finsequence.length(); t++) {
			System.out.print(original[Integer.valueOf(String
					.valueOf(finsequence.charAt(t)))] + " ");
		}

	}

	public static void main(String[] args) {
		Main1 m = new Main1();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line1 = sc.nextLine();
			String line2 = sc.nextLine();
			String[] A = line1.split(" ");
			String[] B = line2.split(" ");
			// 对B进行赋值
			int[] index = new int[B.length];
			// Arrays.fill(B, -1);
			for (int i = 0; i < B.length; i++) {
				index[i] = m.location(A, B[i]);
			}
			// 找顺序对// 找最大顺序队
			m.maxnum(index, A);

		}
	}
}
