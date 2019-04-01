package JingDongOffer;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	// 第一次移除第一个左括号
	// 任意右括号
	public static void fun(String str) {
		if (str == null || str == "") {
			return;
		}
		if (str.length() == 2) {
			System.out.println(2);
			return;
		}
		// 剔除（（）（
		// 剔除）（））
		if (str.length() >= 4) {
			for (int i = 0; i < str.length() - 4; i++) {
				char s1 = str.charAt(i);
				char s2 = str.charAt(i + 1);
				char s3 = str.charAt(i + 2);
				char s4 = str.charAt(i + 3);

				if ((s1 == '(' && s2 == '(' && s3 == ')' && s4 == '(')
						|| (s1 == ')' && s2 == '(' && s3 == ')' && s4 == ')')) {
					// 删除中间括号
					str = str.substring(i + 1, i + 2) + str.substring(i + 3);
				}
			}
			// 统计完整的数目
			Stack stack = new Stack();
			int left = 0;
			int right = 0;
			int sum = 1;
			for (int t = 0; t < str.length(); t++) {
				//System.out.println("aaa" + left + "," + right);
				if (left > 0 && right > 0 && left == right) {
					while (!stack.isEmpty()) {
						stack.pop();
					}
					//System.out.println("tanchu" + left);
					int tempresult = 1;
					for (int j = 1; j <= left; j++) {
						tempresult = tempresult * j;
					}
					System.out.println("tempresult" + tempresult);
					sum *= tempresult;
					left = 0;
					right = 0;
				}

				char temp = str.charAt(t);
				//System.out.println("dangqian--" + temp);
				if (temp == '(') {
					left++;
				} else {
					right++;
				}
				
				stack.push(temp);
			}
			int tempresult = 1;
			for (int j = 1; j <= left; j++) {
				tempresult = tempresult * j;
			}
			//System.out.println("tempresult" + tempresult);
			sum *= tempresult;
			System.out.println(sum);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String bracket = sc.nextLine();
			fun(bracket);
		}
		sc.close();

	}

}
