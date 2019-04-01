package MoniTest;

import java.util.HashSet;
import java.util.Scanner;

public class Main1 {

	public int putSet(String str) {
		//奇数，偶数
		HashSet<String> set1=new HashSet<String>();
		HashSet<String> set2=new HashSet<String>();
		HashSet<String> result=new HashSet<String>();
		for(int i=0;i<str.length();i++){
			int originSize=set1.size();
			set1.add(String.valueOf(str.charAt(i)));
			if(set1.size()==originSize){
				set2.add(String.valueOf(str.charAt(i)));
			}
		}
		int size1=set1.size();
		int size2=set2.size();
		
		int minsize=size1>size2?size2:size1;
		int maxsize=size1>size2?size1:size2;
		if(minsize==0){
			return maxsize;
		}else{
			result.clear();
			result.addAll(set1);
			result.retainAll(set2);
			int huiwennum=0;
			if(result.size()==minsize&&maxsize-minsize!=1){
				huiwennum=1;
			}
				return maxsize-minsize+huiwennum;
			}
		
	}

	public static void main(String[] args) {
		Main1 m = new Main1();
		//System.out.println(m.putSet("aba"));
		Scanner sc = new Scanner(System.in);
		//while (sc.hasNextLine()) {
			// 先整体，后局部
			String word=sc.nextLine();
			if(word.equals("")){
				System.out.println(0);
			}else{
			System.out.println(m.putSet(word));
			}

		//}
	}
}
