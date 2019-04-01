package eBay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
//	public static void sortIntArrs(int[][] a, final int sortCols) {
//		Comparator c = new Comparator() {
//			public int compare(Object o1, Object o2) {
//				return ((Comparable) (Object)o1[sortCols]).compareTo(o2[sortCols]);
//			}
//		};
//		Arrays.sort(a, c);
//	}
//
//	public static int fun(Object[][] loc, Object[][] hole) {
//		// x，y投影
//		// x方向排序
//		sortIntArrs(loc, 0);
//		sortIntArrs(hole, 0);
//		int result = 0;
//		for (int i = 0; i < loc.length; i++) {
//			for (int y = 0; y < 2; y++) {
//				result += Integer.valueOf(String.valueOf(loc[i][y])) - Integer.valueOf(String.valueOf(hole[i][y]));
//			}
//		}
//		sortIntArrs(loc, 1);
//		sortIntArrs(hole, 1);
//		int tempresult = 0;
//		for (int i = 0; i < loc.length; i++) {
//			for (int y = 0; y < 2; y++) {
//				tempresult += Integer.valueOf(String.valueOf(loc[i][y])) - Integer.valueOf(String.valueOf(hole[i][y]));
//			}
//		}
//		//System.out.println(tempresult+","+result);
//		result = Math.min(tempresult, result);
//		return result;
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int n = Integer.valueOf(sc.nextLine());
//		Object[][] loc = new Object[n][2];
//		Object[][] hole = new Object[n][2];
//		for (int i = 0; i < n; i++) {
//			String[] strloc = sc.nextLine().split(" ");
//			loc[i][0] = Integer.valueOf(strloc[0]);
//			loc[i][1] = Integer.valueOf(strloc[1]);
//		}
//		for (int y = 0; y < n; y++) {
//			String[] strloc = sc.nextLine().split(" ");
//			hole[y][0] = Integer.valueOf(strloc[0]);
//			hole[y][1] = Integer.valueOf(strloc[1]);
//		}
//
//		System.out.println(fun(loc, hole));
//		sc.close();
//	}
}
