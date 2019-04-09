package ZPinduoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	//https://www.nowcoder.com/questionTerminal/dc49df3bbc0146dd92322889d40afcb1
	public static int[] visited;
	public static int[] bearNum;

	public static void fun(int[] candy, Map bear) {
		Arrays.sort(candy);
		// 战斗力排序
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(bear.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getKey() - o2.getKey());// 根据key战斗力排序
			}
		});
		int[] result = new int[entryList.size()];
		int[] tempresult = new int[entryList.size()];
		for (int i = entryList.size() - 1; i >= 0; i--) {
			result[i] = entryList.get(i).getValue() - eat(candy, entryList.get(i).getValue());
			// System.out.println(entryList.get(i).getKey() + "---" +
			// loc(entryList.get(i).getKey()));
			tempresult[loc(entryList.get(i).getKey())] = result[i];
		}
		for (int t = 0; t < entryList.size(); t++) {
			System.out.println(tempresult[t]);
		}
	}

	public static int loc(int key) {
		int loc = 0;
		for (int i = 0; i < bearNum.length; i++) {
			if (key == bearNum[i]) {
				loc = i;
				break;
			}
		}
		return loc;
	}

	public static int eat(int[] candy, int hungry) {
		int eatsum = 0;
		for (int i = candy.length - 1; i >= 0; i--) {
			if (visited[i] != 1 && (eatsum + candy[i]) <= hungry) {
				eatsum += candy[i];
				visited[i] = 1;
			}
		}
		return eatsum;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line1 = sc.nextLine();
			String line2 = sc.nextLine();
			String[] l1 = line1.split(" ");
			String[] l2 = line2.split(" ");
			int[] info = new int[2];
			int[] candy = new int[l2.length];

			visited = new int[l2.length];

			info[0] = Integer.valueOf(l1[0]);
			info[1] = Integer.valueOf(l1[1]);
			for (int i = 0; i < info[1]; i++) {
				candy[i] = Integer.valueOf(l2[i]);
			}
			bearNum = new int[info[0]];
			Map bear = new HashMap();
			for (int i = 0; i < info[0]; i++) {
				String[] temp = sc.nextLine().split(" ");
				int power = Integer.valueOf(temp[0]);
				int hungry = Integer.valueOf(temp[1]);
				bear.put(power, hungry);
				bearNum[i] = power;
			}
			fun(candy, bear);

		}
	}

}
