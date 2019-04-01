package jingdongpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		class stack {
			public String status;
			public int price;
			public int quantity;

			public stack(String status, int price, int quantity) {
				super();
				this.status = status;
				this.price = price;
				this.quantity = quantity;
			}

		}
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			// Main2 m = new Main2();
			HashMap<String, stack> map = new HashMap<String, stack>();

			String[] line = sc.nextLine().split(" ");
			int number = Integer.valueOf(line[0]);
			int s = Integer.valueOf(line[1]);
			// 存储判断重复
			for (int i = 0; i < number; i++) {
				String[] temp = sc.nextLine().split(" ");
				String status = temp[0];
				int price = Integer.valueOf(temp[1]);
				int qua = Integer.valueOf(temp[2]);
				// 如果status--price存在 --累加 不存在--创建
				if (map.containsKey(temp[0] + temp[1])) {
					map.get(temp[0] + temp[1]).quantity = map.get(temp[0]
							+ temp[1]).quantity
							+ qua;
				} else {
					stack ss = new stack(status, price, qua);
					map.put(temp[0] + temp[1], ss);
				}
			}

			// 排序
			ArrayList<stack> list = new ArrayList<stack>(map.values());
			Comparator<stack> cpt = new Comparator<stack>() {

				@Override
				public int compare(stack o1, stack o2) {
					// TODO Auto-generated method stub
					if (o1.price > o2.price) {
						return 1;
					} else if (o1.price == o2.price) {
						return 0;
					} else {
						return -1;
					}
				}
			};
			Comparator<stack> cpt1 = new Comparator<stack>() {

				@Override
				public int compare(stack o1, stack o2) {
					// TODO Auto-generated method stub
					if (o1.price > o2.price) {
						return -1;
					} else if (o1.price == o2.price) {
						return 0;
					} else {
						return 1;
					}
				}
			};
			Collections.sort(list, cpt1);

			// 用s控制输出
			// 从前到后输出S
			// 从后到前输出B
			int num = 0;
			for (int i = 0; i < list.size() && num < s; i++) {
				if (list.get(i).status.equals("S")) {
					System.out.println(list.get(i).status + " "
							+ list.get(i).price + " " + list.get(i).quantity);
					num++;
				}
			}
			Collections.sort(list, cpt);

			num = 0;
			for (int i = list.size() - 1; i >= 0 && num < s; i--) {
				if (list.get(i).status.equals("B")) {
					System.out.println(list.get(i).status + " "
							+ list.get(i).price + " " + list.get(i).quantity);
					num++;
				}
			}
		}
	}
}
