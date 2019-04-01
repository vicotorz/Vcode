package DiDiFinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] line = sc.nextLine().split(" ");
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < line.length; i++) {
				list.add(Integer.valueOf(line[i]));
			}
			int num = sc.nextInt();
			if (num > line.length) {
				System.out.println("-1");
			} else {
				Collections.sort(list);
				System.out.println(list.get(line.length - num));
			}

		}
		sc.close();

	}

}
