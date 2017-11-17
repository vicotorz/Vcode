package ZOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PaiLie {
	// 求全排列问题，就是树的深度遍历问题
	public static ArrayList<String> getPermutation(String A) {
		// write code here
		if (A == null) {
			return null;
		}

		char[] ch = A.toCharArray();
		ArrayList<String> result = new ArrayList<String>();
		Set<String> set = new HashSet<String>();

		find(ch, set, result, A);

		return result;
	}

	public static void find(char[] ch, Set<String> set, ArrayList result, String str) {
		// System.out.println(str);
		if (!set.contains(str)) {
			result.add(str);
			set.add(str);
		} else {
			return;
		}
		for (int i = 1; i < ch.length; i++) {
			// 交换
			char temp = ch[i];
			ch[i] = ch[0];
			ch[0] = temp;
			StringBuilder st = new StringBuilder();
			for (char e : ch) {
				st.append(e);
			}
			find(ch, set, result, st.toString());
			// 回溯
			char temp1 = ch[i];
			ch[i] = ch[0];
			ch[0] = temp1;
		}
	}

	public static void main(String[] args) {
		String str = "ABC";
		getPermutation(str);
	}
}
