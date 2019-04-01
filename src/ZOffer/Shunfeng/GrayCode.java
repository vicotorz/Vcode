package Shunfeng;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public static List<Integer> grayCode(int n) {
		if (n < 0)
			return new ArrayList<Integer>();
		if (n == 0) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(0);
			return list;
		}

		List<Integer> tmp = grayCode(n - 1);
		List<Integer> result = new ArrayList<Integer>(tmp);
		int addNumber = 1 << (n - 1);
		System.out.println(addNumber);
		for (int i = tmp.size() - 1; i >= 0; i--) {
			result.add(addNumber + tmp.get(i));
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> list=grayCode(2);
		for(int e:list){
			System.out.print(e+" ");
		}
	}

}
