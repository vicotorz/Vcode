package CuBao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

	public static void fun() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		String[] str = sc.nextLine().split(" ");
		String[] st = sc.nextLine().split(" ");
		int[] root = new int[str.length];
		int[] value = new int[st.length];
		for (int i = 0; i < str.length; i++) {
			root[i] = Integer.valueOf(str[i]);
		}
		for (int y = 0; y < st.length; y++) {
			value[y] = Integer.valueOf(st[y]);
		}
		// 组装list
		ArrayList<ArrayList<Integer>> list = new ArrayList();
		sc.close();
	}

}
