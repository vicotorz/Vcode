package huawei;

import java.util.Scanner;

public class Main2 {
//https://www.nowcoder.com/questionTerminal/0a92c75f5d6b4db28fcfa3e65e5c9b3f
	/**
	 * 检验两个手牌的大小 赋值 级别 牌数 对王 10 2 炸弹（4个一样） 一个数 4 同顺子（12345） 5牌 最小数 5 三个 3牌 一个数 3
	 * 对子 一个数 2 个子 一个数 1
	 * 
	 * （1）除了炸弹和对王之外，其他必须同类型比较。 （2）输入已经保证合法性，不用检查输入是否是合法的牌。
	 * （3）输入的顺子已经经过从小到大排序，因此不用再排序了.
	 * 
	 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
	 * 
	 * 条件多，没有考虑字母牌的情况
	 */
	public String[] replace(String[] g) {
		for (int i = 0; i < g.length; i++) {
			
			if (g[i].equals("J")) {
                g[i]="11";
			}
			if (g[i].equals("Q")) {
                g[i]="13";
			}
			if (g[i].equals("K")) {
				g[i]="14";
			}
			if (g[i].equals("A")) {
				g[i]="15";

			}
			if(g[i].equals("2")){
				g[i]="16";
			}
			
			
		}
		return g;
	}

	public int Compare(String[] a, String[] b) {
		// 替换所有 J Q K A 2
		String[] tempa=a.clone();
		String[] tempb=b.clone();
		tempa=replace(tempa);
		tempb=replace(tempb);
		int win = 0;// 1--a b--2
		int size1 = tempa.length;
		String level1;
		int size2 = tempb.length;
		String level2;
		level1 = getlevel(size1, tempa);
		level2 = getlevel(size2, tempb);
		 System.out.println(level1+"  "+level2);
		int le1 = Integer.valueOf(level1);
		int le2 = Integer.valueOf(level2);
		 if((size1==4||size2==4)&&(size1==5||size2==5)){
    		if(size1==4){
				win=1;
			}else{
			 win=2;
			}
       }else{
    	   if(size1==size2||(le1==1717171717||le2==1717171717)||(size1==4||size2==4)){
    	   if (le1 > le2) {
				win = 1;
			} else if (le1 < le2) {
				win = 2;
			}
    	   }else{
    		   win=0;
    	   }
			}		
		return win;
}


	public String getlevel(int size, String[] ab) {
		// System.out.println("赋值"+ size);
		String level = "-1";
		switch (size) {
		case 1:
			level = ab[0];
			break;
		case 2:
			if (ab[0].equalsIgnoreCase("JOKER")) {
				level = "1717171717";
				break;
			} else {
				level = ab[0] + ab[0];
				break;
			}
		case 3:
			level = ab[0] + ab[0] + ab[0];
			break;
		case 4:
			level = ab[0] + ab[0] + ab[0] + ab[0];
			break;
		case 5:
			level = ab[0] + ab[0] + ab[0] + ab[0] + ab[0];
			break;
		}
		return level;
	}

	public static void main(String[] args) {
		Main2 m = new Main2();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// 输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如4 4 4 4-joker JOKER
			String line = sc.nextLine();
			String[] temp = line.split("-");
			String[] per1 = temp[0].split(" ");
			String[] per2 = temp[1].split(" ");

			int win = m.Compare(per1, per2);
			if (win == 0) {
				System.out.println("ERROR");
			} else if (win == 1) {
				for (int i = 0; i < per1.length; i++) {
                    if(i!=per1.length-1){
					System.out.print(per1[i] + " ");
                    }else{
                        System.out.print(per1[i]);
                    }
				}
			} else {
				for (int i = 0; i < per2.length; i++) {
					if(i!=per2.length-1){
					System.out.print(per2[i] + " ");
                    }else{
                        System.out.print(per2[i]);
                    }
				}
			}
		}

	}

}
