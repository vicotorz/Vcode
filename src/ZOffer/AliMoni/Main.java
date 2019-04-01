package AliMoni;

import java.util.*;

public class Main {
	/** 请完成下面这个函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/

	static int pick(int[] peaches) {
		int length = peaches.length;
		int[] number = new int[length];
		number[0] = 1;
		for (int i = 0; i < length; i++) {
			for (int j = i; j >= 0; j--) {
				// System.out.println(j);
				if (peaches[i] > peaches[j]) {
					number[i] = number[j] + 1;
					break;
				}
				if (j == 0) {
					number[i] = 1;
				}
			}
		}
		int max = number[0];
		for (int t = 0; t < length; t++) {
			if (number[t] > max) {
				max = number[t];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int trees = Integer.parseInt(in.nextLine().trim());
		int[] peaches = new int[trees];
		for (int i = 0; i < peaches.length; i++) {
			peaches[i] = Integer.parseInt(in.nextLine().trim());
		}
		System.out.println(pick(peaches));
	}

	// int length = peaches.length;
	// int[] number = new int[length];
	// number[0] = 1;
	// for (int i = 0; i < length; i++) {
	// for (int j = i; j >= 0; j--) {
	// System.out.println(j);
	// if (peaches[i] > peaches[j]) {
	// number[i] = number[j] + 1;
	// break;
	// }
	// if (j == 0) {
	// number[i] = 1;
	// }
	// }
	// }
	//
	// return number[length - 1];

}