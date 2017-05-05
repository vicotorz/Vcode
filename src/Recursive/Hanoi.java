package Recursive;
public class Hanoi {

	/**
	 * 汉诺塔的实现
	 * 
	 * 2014.6.21晚开始写
	 * 
	 * 问题描述：有三根柱子，第一根有64个盘子，从上到下盘子越来越大，将64个盘子全部移动第三个柱子上。移动的时候，只能小盘子压着大盘子。
	 * 而且每次只能移动一个盘子
	 * 
	 * 递归思想 第一，把a上的n-1个盘通过c移动到b。 第二，把a上的最下面的盘移到c。
	 * 第三，把b当做a重复以上步骤就好了（因为n-1个盘全在b上了）。
	 * 所以算法看起来就简单多了。不过，思考过程还是很痛苦的，难以理解。递归中会保存数据的好处在这里又得到体现，太神奇了。
	 */

	public void move(int n, char a, char b, char c) {// n个盘子 a移动到c上 借助b
		// n为第n个盘子
		if (n == 1) {
			// 如果是一个
			System.out.println("盘 " + n + " 由 " + a + " 移至 " + c); // 当n只有1个的时候直接从a移动到c
		} else {
			move(n - 1, a, c, b);// ????//第n-1个要从a通过c移动到b
			System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
			move(n - 1, b, a, c);// ????//n-1个移动过来之后b变开始盘，b通过a移动到c，这边很难理解
		}
	}

	public static void main(String[] args) {
		Hanoi test = new Hanoi();
		test.move(5, 'a', 'b', 'c');

	}
}
