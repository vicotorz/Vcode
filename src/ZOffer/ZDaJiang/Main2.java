package ZDaJiang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//满足要求的连续子序列个数
//时间限制：C/C++语言 1000MS；其他语言 3000MS
//内存限制：C/C++语言 65536KB；其他语言 589824KB
//题目描述：
//给出n个数字(n <= 100000，数字范围为[0, 100000])，要求找出序列中有多少个连续子序列满足以下要求：子序列中任意一个数字出现次数小于k
//输入
//第一行输入n(n < 100000)和k(k < 100000)
//然后输入n个数字(范围为[0,100000])
//输出
//满足要求的连续子序列个数
//
//样例输入
//4 1
//1 2 2 3
//样例输出
//6
//
//Hint
//对于1 2 2 3序列，满足要求的子序列区间为[1,1] [2,2] [3,3] [4, 4] [1, 2] [3, 4]
//温馨提示
//请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果 
//点击“调试”亦可保存代码
//编程题可以使用本地编译器，此页面不记录跳出次数
public class Main2 {
	public static void fun(ArrayList<Integer> list, int n, int k) {
		int[] dp = new int[n];
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int e : list) {
			m.put(e, 1);
		}
		for (int i = 0, j = 0; j < n && i < n; j++) {
			m.put(j, m.get(list.get(j)) + 1);
			if (m.get(list.get(j)) <= k) {
				dp[j] = j - i + 1;
			} else {
				while (++i <= j && list.get(i - 1) != list.get(j)) {
					m.put(i - 1, m.get(list.get(i - 1)) - 1);
				}
				dp[j] = j - i + 1;
			}
		}
		int sum = 0;
		for (int i = 0; i < dp.length; i++) {
			sum += dp[i];
		}
		System.out.println(sum);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] line1 = sc.nextLine().split(" ");
			String[] line2 = sc.nextLine().split(" ");

			int n = Integer.valueOf(line1[0]);
			int k = Integer.valueOf(line1[1]);
			int[] num = new int[n];
			// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				num[i] = Integer.valueOf(line2[i]);
				// if (map.get(num[i]) != null) {
				// int value = (int) map.get(num[i]);
				// map.replace(num[i], value, value + 1);
				// } else {
				// map.put(num[i], 1);
				// }
				list.add(num[i]);
			}
			fun(list, n, k);

		}
	}

}

// System.out.println("diaoyong1");
// List<Map.Entry<Integer, Integer>> entryList = new
// ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
//
// Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
// public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer,
// Integer> o2) {
// // return (o1.getKey() - o2.getKey());// 根据key排序
// return (o1.getValue() - o2.getValue());// 根据value排序
// // return (o1.getKey()).toString().compareTo(o2.getKey());
// }
// });
// System.out.println(entryList.size());
//
// HashMap<Integer, Integer> tempmap = new HashMap<Integer, Integer>();
// for (int i = 0; i < entryList.size(); i++) {
// Map.Entry<Integer, Integer> m = entryList.get(i);
// if (m.getValue() < k) {
// tempmap.put(m.getKey(), m.getValue());
// }
// }
// System.out.println(tempmap.size());
//
// List<Map.Entry<Integer, Integer>> FentryList = new
// ArrayList<Map.Entry<Integer, Integer>>(tempmap.entrySet());
// Collections.sort(FentryList, new Comparator<Map.Entry<Integer, Integer>>() {
// public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer,
// Integer> o2) {
// return (o1.getKey() - o2.getKey());// 根据key排序
// // return (o1.getValue() - o2.getValue());// 根据value排序
// // return (o1.getKey()).toString().compareTo(o2.getKey());
// }
// });
//
// HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
// int resultCount = 0;
// for (int i = 0; i < FentryList.size(); i++) {
// int tempkey = FentryList.get(i).getKey();
// int tempvalue = FentryList.get(i).getValue();
// for (int y = i; y < FentryList.size(); y++) {
// if (result.containsKey(tempkey) && result.get(tempkey) != tempvalue) {
// result.put(tempkey, tempvalue);
// resultCount++;
// }
// }
// }
// System.out.println(resultCount);
