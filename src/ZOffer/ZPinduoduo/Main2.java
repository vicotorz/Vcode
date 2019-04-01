package ZPinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static String rootfile;

	public static void print(List[] result) {
		System.out.println(rootfile);
		for (int i = 0; i < result.length; i++) {
			List templist = result[i];
			int size = templist.size();
			int t = 0;
			for (; t < templist.size() - 1; t++) {
				System.out.println("|-- " + templist.get(t));
			}
			//if(result[])
			if (t == templist.size() - 1) {
				System.out.println("`--" + templist.get(t));
			}
			
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int num = Integer.valueOf(sc.nextLine());
			List[] result = new List[num];
			for (int i = 0; i < num; i++) {
				result[i] = new ArrayList();
			}

			for (int i = 0; i < num; i++) {
				String[] str = sc.nextLine().split(" ");
				int loc = Integer.valueOf(str[1]);
				if (loc == -1) {
					rootfile = str[0];
				} else {
					result[loc].add(str[0]);
				}
			}
			print(result);

		}
	}

}
