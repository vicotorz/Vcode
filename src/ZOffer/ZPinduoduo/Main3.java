package ZPinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//https://www.nowcoder.com/questionTerminal/2493f77ad22d4c20a7e53085950bfeca
public class Main3 {
	public static Map GoodMap;
	public static List<List> Activity;

	public static int activityNum = 0;
	public static int step = 0;

	// 秒杀活动 add
	public static int add(int startTime, int endTime, int goodid, int limitQuantity) {
		int[] info = (int[]) GoodMap.get(goodid);
		if (limitQuantity > info[1]) {
			return -1;
		} else {
			//同一个goodid放在一个list中
			List act = new ArrayList();
			act.add(startTime);
			act.add(endTime);
			act.add(goodid);
			act.add(limitQuantity);
			info[1] = info[1] = limitQuantity;
			GoodMap.replace(goodid, info);
			Activity.add(act);
			activityNum++;
		}
		return activityNum - 1;

		// 成功 活动id

		// 数量大于库存，失败 -1
	}

	// 购买秒杀商品
	public static int buyGoods(int activity, int quantity) {
		List act = Activity.get(activity);
		if (quantity > (int) act.get(3)) {
			return -1;
		} else if (step < (int) act.get(0) || step > (int) act.get(1)) {
			return -1;
		} else {
			int total = (int) act.get(3);
			act.remove(3);
			act.add(total - quantity);
			return 0;
		}

		// 成功 0

		// 大于数量 -1

		// （未开始，结束） -1

	}

	public static void getActivityList() {
		// 进行中,还有>进行中，没有了>未开始

		// 返回秒杀id列表
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			int N = Integer.valueOf(str[0]);
			int M = Integer.valueOf(str[1]);
			for (int i = 0; i < N; i++) {
				String[] line = sc.nextLine().split(" ");
				int[] info = new int[2];
				info[0] = Integer.valueOf(line[0]);
				info[1] = Integer.valueOf(line[1]);
				GoodMap.put(line[0], info);
			}
			for (int t = 0; t < M; t++) {
				step++;
				String readline = sc.nextLine();
				if (readline.contains("add")) {
					String[] temp = readline.split(" ");
					int startTime = Integer.valueOf(temp[2]);
					int endTime = Integer.valueOf(temp[3]);
					int goodid = Integer.valueOf(temp[4]);
					int limitQuantity = Integer.valueOf(temp[5]);
					System.out.println(add(startTime, endTime, goodid, limitQuantity));
				}

				if (readline.contains("buy")) {
					String[] temp = readline.split(" ");
					int activity = Integer.valueOf(temp[0]);
					int quantity = Integer.valueOf(temp[1]);
					System.out.println(buyGoods(activity, quantity));
				}

				if (readline.contains("list")) {
					getActivityList();
				}
			}

		}
	}

}
