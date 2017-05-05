package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class leetcode3 {
	public static void main(String[] args) {
		Point[] points = { new Point(0, 0), new Point(1, 0) };
		leetcode3 l = new leetcode3();
		System.out.println(l.maxPoints(points));
	}

	public int maxPoints(Point[] points) {
		HashMap<String, status> map = new HashMap<String, status>();
		int size = points.length;
		if (size <= 0) {
			return 0;
		} else if (size == 1) {
			return 1;
		} else {
			for (int i = 0; i < size; i++) {
				for (int j = i; j < size; j++) {
					if (i == j) {
						continue;
					}
					int x1 = points[i].x;
					int y1 = points[i].y;
					int x2 = points[j].x;
					int y2 = points[j].y;
					double k;
					if (x2 - x1 != 0) {
						k = (y2 - y1) / (x2 - x1);
					} else {
						k = Double.MAX_VALUE;
					}
					double b = y1 - k * x1;
					String str = String.valueOf(k) + String.valueOf(b);
					status s = map.get(str);
					if (s == null) {
						map.put(str, new status(k, b));
					} else {
						s.count++;
					}
				}
			}
		}

		// 统计count数
		ArrayList<status> list = new ArrayList<status>(map.values());
		Collections.sort(list, new Comparator<status>() {

			public int compare(status o1, status o2) {
				// TODO Auto-generated method stub
				if (o1.count > o2.count) {
					return 1;
				} else if (o1.count == o2.count) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		System.out.println(list.get(0).count+1);
		return list.get(0).count+1;
	}
}

// 直线的k和b的值
class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

class status {
	public double k;
	public double b;
	static int count;

	status(double k, double b) {
		this.k = k;
		this.b = b;
		count++;
	}

}
