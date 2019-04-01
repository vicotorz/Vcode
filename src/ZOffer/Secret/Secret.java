package Secret;

import java.util.ArrayList;

public class Secret {
	String[] STR = { "xxx", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
			"S", "T", "U", "V", "W", "X", "Y", "Z" };
	ArrayList<String> list = new ArrayList<String>();
	
	public void getSecret(String str, String result) {
		System.out.println(str);
		if (str.length() == 1) {
			list.add(result + STR[Integer.valueOf(str.substring(0, str.length()))]);
			result = null;
			return;
		}
		String s1 = str.substring(0, 1);
		String s2 = str.substring(0, 2);
		int num1 = Integer.valueOf(s1);
		int num2 = Integer.valueOf(s2);

		getSecret(str.substring(1, str.length()), result + STR[num1]);
		if (num2 >= 1 && num2 <= 26) {
			getSecret(str.substring(2, str.length()), result + STR[num2]);
		}
		return;
	}

	// 一段数字转化成字母
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Secret s = new Secret();
		s.getSecret("12259", new String());
		for (String e : s.list) {
			System.out.println(e);
		}
	}

}
