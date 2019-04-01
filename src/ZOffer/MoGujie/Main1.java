package MoGujie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {

	public static void fun(String[] str) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < str.length; i++) {
			int n = Integer.valueOf(str[i]);

			if (!map.containsKey(n)) {
				// System.out.println("[1]" + n);
				map.put(n, 1);
			} else {
				// System.out.println("[2]" + n);
				int value = map.get(n);
				map.put(n, value + 1);
				// map.put(n, value + 1);
			}
		}
		// 根据value排序
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		StringBuffer sb = new StringBuffer();
		int PreValue = entryList.get(0).getValue();
		Stack<String> stack = new Stack<String>();
		for (int t = 0; t < entryList.size(); t++) {
			int curValue = entryList.get(t).getValue();
			//System.out.println("zhege");
			//System.out.println(entryList.get(t).getKey() + "-" + entryList.get(t).getValue());
			//System.out.println(curValue+"------aaa---"+PreValue);
			if (curValue != PreValue) {
				// 弹出
				while (!stack.isEmpty()) {
					//System.out.println("tanchu" + stack.peek());
					sb.append(stack.pop());
				}
				String s = entryList.get(t).getKey() + "-" + entryList.get(t).getValue() + " ";
				stack.push(s);
			} else {
				//System.out.println("jinru");
				String s = entryList.get(t).getKey() + "-" + entryList.get(t).getValue() + " ";
				stack.push(s);
			}
			PreValue = curValue;
			// String s = entryList.get(t).getKey() + "-" +
			// entryList.get(t).getValue() + " ";
			// sb.append(s);
			//System.out.println(sb);
		}
		//System.out.println(stack.size());
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.next().split("-");
			fun(str);
		}
		sc.close();
	}

}
