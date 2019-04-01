package Xiecheng;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

	/*
	 * 请完成下面这个函数，实现题目要求的功能 当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 开始写代码
	 ******************************/
	static int findMinMis(int[] A) {
		Arrays.sort(A);
		int result = -1;
		for (int i = 0; i < A.length; i++) {
			// System.out.println(A[i] + "," + result);
			if ((A[i] > 0 && result < 0) || (result > 0 && A[i] - result == 1)) {
				result = A[i];
			} else if (A[i] <= 0) {
				continue;
			} else {
				result = result + 1;
				break;
			}
		}
		if (result == -1) {
			result = 1;
		}
		if (result == A[A.length - 1]) {
			result = result + 1;
		}
		return result;
	}

	/****************************** 结束写代码 ******************************/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int _A_size = 0;
		_A_size = Integer.parseInt(in.nextLine().trim());
		int[] _A = new int[_A_size];
		int _A_item;
		for (int _A_i = 0; _A_i < _A_size; _A_i++) {
			_A_item = Integer.parseInt(in.nextLine().trim());
			_A[_A_i] = _A_item;
		}

		res = findMinMis(_A);
		System.out.println(String.valueOf(res));

	}
}
