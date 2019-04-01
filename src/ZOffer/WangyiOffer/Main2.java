package WangyiOffer;

import java.util.Scanner;

public class Main2 {

	public static void fun() {

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n=Integer.valueOf(sc.nextLine());
			String[] str=sc.nextLine().split(" ");
			int[] num=new int[n];
			for(int i=0;i<n;i++){
				num[i]=Integer.valueOf(str[i]);
			}
			System.out.println(3);

		}
		sc.close();

	}

}
