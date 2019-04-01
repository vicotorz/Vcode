package TouTiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void func(Map map) {
		map.keySet();
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getKey() - o2.getKey());// 根据key排序
				// return (o1.getValue() - o2.getValue());// 根据value排序
				// return (o1.getKey()).toString().compareTo(o2.getKey());
			}
		});
		
		int curkey = -1;
		int curval = -1;
		HashMap mresult = new HashMap<>();
		for (Map.Entry<Integer, Integer> t : entryList) {
			if (t.getValue() > curval) {
				curkey = t.getKey();
				curval = t.getValue();
			}
			if (t.getValue() < curval) {
				mresult.put(curkey, curval);
				curkey = t.getKey();
				curval = t.getValue();
			}
		}
		if(curkey!=-1&&curval!=-1){
		mresult.put(curkey, curval);
		}
		for (Object key : mresult.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine().trim());
		Map map = new HashMap<>();
		// while (sc.hasNext()) {
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			int x = Integer.valueOf(str[0]);
			int y = Integer.valueOf(str[1]);
			map.put(x, y);
		}
		// }
		func(map);
		sc.close();
	}
}
