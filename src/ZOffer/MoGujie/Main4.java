package MoGujie;

import java.util.Scanner;

public class Main4 {
	public static String fun(int n, int m) {
		String result = null;
		if (m > n) {
			result = "lose";
			return result;
		}
		if (m == n) {
			result = "win " + n;
			return result;
		}
		if (m < n) {
			
			for(int i=1;i<=n;i++){
				if((n-i)%m==0){
					result="loose";
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			int n = Integer.valueOf(str[0]);
			int m = Integer.valueOf(str[1]);
			System.out.println(fun(n, m));
		}

	}

}
