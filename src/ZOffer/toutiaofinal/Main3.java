package toutiaofinal;

import java.util.Scanner;

public class Main3 {

	public static int match(String word, String paper) {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			int loc = paper.indexOf(word.charAt(i));
			//System.out.println(loc + "," + word.charAt(i) + "," + paper);
			paper = paper.substring(loc + 1, paper.length());
			if (loc < 0) {
				return 0;
			} else {
				if (i != 0) {
					count += loc;
				}
			}
		}

		return 100 - count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String word = sc.nextLine();
			String paper = sc.nextLine();
			System.out.println(match(word, paper));
		}

	}

}
