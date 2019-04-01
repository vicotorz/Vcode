package Haiwei_shixi;

import java.util.ArrayList;

/**
 * 100-trade-done 1*trade*done
 * 
 * 如果pattern=200-?*-done : filter(100-trade-done, pattern) = 0,
 * filter(200-trade-done, pattern) = 1, filter(200-paid-done, pattern) = 1
 * 
 * 
 * pattern=*trade-done filter(100-trade-done, pattern) = 1,
 * filter(200-trade-done, pattern) = 1, filter(200-paid-done, pattern) = 0
 * 
 * 
 * pattern=1*trade*done : filter(100-trade-done, pattern) = 1,
 * filter(200-trade-done, pattern) = 0, filter(200-paid-done, pattern) = 0
 */
public class Main4 {
	public int filter(String str, String pattern) {
		int flag = 0;
		// 将pattern传进行处理
		// 先-拆分 *拆分 ？拆分
		String[] p = pattern.split("\\*");
		ArrayList<String> list = new ArrayList<String>();

		// 如果全部匹配则通过
		int count = 0;
		for (int i = 0; i < p.length; i++) {
			if (str.contains(p[i])) {
				count++;
			}
		}
		// System.out.println(count);

		if (count == p.length) {
			flag = 1;
		}
		return flag;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ？ 匹配一个字符
		// * 匹配任意连串字符
		// Scanner sc = new Scanner(System.in);
		// String str = sc.nextLine();
		// String pattern = sc.nextLine();
		Main4 m = new Main4();
		// System.out.println(m.filter(str, pattern));
		System.out.println(m.filter("200-trade-done", "200-?*-done"));

	}
}
