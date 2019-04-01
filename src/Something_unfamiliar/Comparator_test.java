package something_unfamiliar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

/**
 * 实现comparator 比较方法
 * 
 * 把给定顺序的数组按照一定顺序打乱
 * */
public class Comparator_test {
	public static void main(String[] args) {
		// 按照给定顺序打乱
		Random r = new Random();
		randomSet rs = new randomSet();
		HashSet<Integer> hs = new HashSet<Integer>();
		rs.randomSet(0, 9, 10, hs);
		Object[] a = hs.toArray();
		a[1] = 9098;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Object rr : a) {
			list.add(Integer.valueOf(rr.toString()));
			System.out.print(rr + " ");
		}
		System.out.println();
		// 根据set中的值，调整数组中的内容
		Comparator cpt = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				int tempo1 = Integer.valueOf(o1.toString());
				int tempo2 = Integer.valueOf(o2.toString());
				System.out.println(tempo1 + " " + tempo2 + " "
						+ (tempo1 >= tempo2 ? tempo1 : tempo2));
				// 重点！
				if (tempo1 > tempo2) {
					return 1;
				} else if (tempo1 == tempo2) {
					return 0;
				} else {
					return -1;
				}
			}
		};

		Collections.sort(list, cpt);
		for (Integer tt : list) {
			System.out.print(tt + " ");
		}
		System.out.println();

	}
}
