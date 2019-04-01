package AliMoni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
	public static int price = 2000;
	public static int length;
	public static int width;
	public static int height;

	public static class Model {
		public int price;
		public int length;
		public int width;
		public int height;
	}

	static Model[] items;
	static ArrayList<Integer> pricelist;

	static boolean[] visited;

	public static int[] getInfo(int price) {
		int[] info = new int[3];
		for (int i = 0; i < pricelist.size(); i++) {
			if (price == items[i].price && visited[i] == false) {
				info[0] = items[i].length;
				info[1] = items[i].width;
				info[2] = items[i].height;
				visited[i] = true;
			}
		}
		return info;
	}

	public static int[] sortNum(int i, int j, int t) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(i);
		list.add(j);
		list.add(t);
		Collections.sort(list);
		int[] result = new int[3];
		Object[] temp = list.toArray();
		for (int ii = 0; ii < 3; ii++) {
			result[ii] = (int) temp[ii];
		}
		return result;
	}

	private static int process() {

		int boxnum = 0;
		int shengprice = 2000;
		int shenglength = length;
		int shengwidth = width;
		int shengheight = height;

		for (int i = pricelist.size() - 1; i >= 0; i--) {
			// 每次选最大
			int[] info = getInfo(pricelist.get(i));
			// 无解
			if (pricelist.get(i) > 2000 || pricelist.get(i) <= 0) {
				return -1;
			}

			int Mininfo = Math.min(Math.min(info[0], info[1]), info[2]);
			int MaxBox = Math.max(Math.max(length, width), height);


			if (Mininfo > MaxBox) {
				return -1;
			}
			if (info[0] <= 0 || info[1] <= 0 || info[2] <= 0) {
				return -1;
			}

			// 可以各种姿势放
			// 小的对小的，大的对大的
			int[] temp = sortNum(shenglength, shengwidth, shengheight);
			int[] gooding = sortNum(info[0], info[1], info[2]);

			shenglength = temp[0];
			shengwidth = temp[1];
			shengheight = temp[2];

			info[0] = gooding[0];
			info[1] = gooding[1];
			info[2] = gooding[2];

			shengprice = shengprice - pricelist.get(i);
			shenglength = shenglength - info[0];
			shengwidth = shengwidth - info[1];
			shengheight = shengheight - info[2];
			if (shengprice < 0 || shenglength < 0 || shengwidth < 0 || shengheight < 0) {
				return -1;
			}
			if (shengprice <= 0 || shenglength <= 0 || shengwidth <= 0 || shengheight <= 0) {
				// 不能再加了
				boxnum++;
				shengprice = 2000;
				shenglength = length;
				shengwidth = width;
				shengheight = height;
			}
		}

		return boxnum;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		pricelist = new ArrayList<>();

		while (scanner.hasNext()) {
			length = scanner.nextInt();
			width = scanner.nextInt();
			height = scanner.nextInt();

			int itemNum = scanner.nextInt();
			items = new Model[itemNum];
			for (int i = 0; i < itemNum; i++) {
				Model item = new Model();
				int tempprice = scanner.nextInt();
				item.price = tempprice;
				pricelist.add(tempprice);
				item.length = scanner.nextInt();
				item.width = scanner.nextInt();
				item.height = scanner.nextInt();
				items[i] = item;
			}
			visited = new boolean[itemNum];
			Collections.sort(pricelist);
			long startTime = System.currentTimeMillis();
			// boxMinNum = Integer.MAX_VALUE;
			System.out.println(process());

		}

	}
}