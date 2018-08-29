package ZOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public String deal(ArrayList<String> list, String str) {
		StringBuffer fsb = new StringBuffer(str);
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			byte[] temps = s.getBytes();
			Arrays.sort(temps);
			s = new String(temps);
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < s.length(); j++) {
				// 将这些位置上的字符拿出来排序
				int loc = Integer.valueOf(String.valueOf(s.charAt(j)));
				sb.append(str.charAt(loc));
			}
			//System.out.println("paixuqian" + sb.toString());
			byte[] b = sb.toString().getBytes();
			Arrays.sort(b);
			String finalstr = new String(b);
			//System.out.println("paixuhou" + finalstr);
			// 再按照这些顺序装上去

			for (int j = 0; j < s.length(); j++) {
				// 将这些位置上的字符拿出来排序
				int loc = Integer.valueOf(String.valueOf(s.charAt(j)));
				// loc的位置需要替换成 finalstr.charAt(j)
				//System.out.println(loc + "anzhuang" + String.valueOf(finalstr.charAt(j)));
				fsb.delete(loc, loc + 1);
				fsb.replace(loc, loc, String.valueOf(finalstr.charAt(j)));
			}
		}
		return fsb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int number = Integer.valueOf(sc.nextLine());
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < number; i++) {
			String l = sc.nextLine();
			String[] s = l.split(" ");
			for (int t = 0; t < list.size(); t++) {
				// System.out.println("chazhao" + s[0] + s[1]);
				//System.out.println(list.get(t) + "---" + s[0] + "--" + s[1] + list.get(t).contains(s[0]));
				String string = (String) list.get(t);
				if (list.get(t).contains(s[0])) {
					//System.out.println("[1]");
					string = string + s[1];
					list.set(t, string);
					break;
				} else if (list.get(t).contains(s[1])) {
					//System.out.println("[2]");
					string = string + s[0];
					list.set(t, string);
					break;
				}
				if (t == list.size() - 1) {
					//System.out.println();
					//System.out.println("yaojiaru" + (s[0] + s[1]));
					list.add(s[0] + s[1]);
					break;
				}
			}
			if (list.size() == 0) {
				list.add(s[0] + s[1]);
			}
			//System.out.println("====");
			//for (String e : list) {
			//	System.out.println(e);
			//}

		}

		Main2 m = new Main2();
		System.out.println(m.deal(list, str));
	}

}
