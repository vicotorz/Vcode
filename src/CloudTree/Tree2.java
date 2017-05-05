package CloudTree;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;

public class Tree2 extends JFrame {

	/**
	 * 利用云模型真是模拟不确定性现象
	 * 
	 * 随机变化量：左偏角，右偏角，左长度，右长度
	 * 
	 * Box-Muller算法 由普通随机数---均匀分布随机数---高斯分布随机数
	 * 
	 * srand((unsigned)time(NULL)); x=rand();
	 * //x就是由基于系统时钟产生的随机数，一个典型的可能的取值可以是：134238 y=(float)(x0);
	 * //这个随机数和100求余的结果必然得到一个小与100的整数，然后强制转换成浮点数 y=y/100; //这个数除以100，会得到一个小与1的数。
	 * return y;
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Tree2 a = new Tree2();

		a.draw();

	}

	// 专门产生随机数
	public double ranGaussian(double Ex, double H) {
		double num1 = Math.random();// 产生一个0.0~1.0的随机数
		double num2 = Math.random();
		double A = Math.sqrt((-2) * Math.log(num1));
		double B = 2 * Math.PI * num2;
		double C = A * Math.cos(B);
		// 期望+数*方差
		double number = Ex + C * H;
		return number;
	}

	// 左偏角
	public double getLeftangle() {
		// {40,0.05,0.001}
		// 产生一个随机数
		double x = ranGaussian(40,
				Math.pow(ranGaussian(0.05, Math.pow(0.001, 2)), 2));
		Scanner sc = new Scanner(System.in);
		//sc.nextLine();
		System.out.println("左偏角" + x);
		return x;
	}

	// 右偏角
	public double getRightangle() {
		double x = ranGaussian(40,
				Math.pow(ranGaussian(0.05, Math.pow(0.001, 2)), 2));
		Scanner sc = new Scanner(System.in);
		//sc.nextLine();
		System.out.println("右偏角" + x);
		return x;
	}

	// 获得左边长
	public double getLL() {
		double x = ranGaussian(0.7,
				Math.pow(ranGaussian(0.1, Math.pow(0.01, 2)), 2));
		Scanner sc = new Scanner(System.in);
		//sc.nextLine();
		System.out.println("左边长" + x);
		return x;
	}

	// 获得右边长
	public double getLR() {
		double x = ranGaussian(0.7,
				Math.pow(ranGaussian(0.1, Math.pow(0.01, 2)), 2));
		Scanner sc = new Scanner(System.in);
		//sc.nextLine();
		System.out.println("右边长" + x);
		return x;
	}

	public void draw() {// 绘制窗体，添画布

		this.setSize(1000, 700);//

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(3);

		this.setVisible(true);
		this.setBackground(Color.white);
		Graphics g = this.getGraphics();
		g.translate(0, -800);

	}

	// 画出边框
	public void paint(Graphics g) {
		// System.out.println("paint");
		// Scanner sc = new Scanner(System.in);
		// sc.next();
		super.paint(g);

		// 调用show函数
		g.drawLine((int) 500, (int) 590, (int) 500, (int) 490);
		this.Show(500, 490, 100, 100, Math.PI * 60 / 180, Math.PI * 60 / 180,
				15, g);

		// (Math.PI为180°)

	}

	// 起点坐标 长度 左偏角 右偏角
	public void Show(double x0, double y0, double ll, double lr, double a,
			double b, double count, Graphics g) {

		double x1;

		double y1;

		double x2;

		double y2;

		if (count < 1)

		{

			return;

		}

		// 判断是否继续进行递归调用，注意：判断一定要放在递归调用之前，否则这段代码将永远不会被执行

		// 左树枝点确定
		x1 = x0 - ll * Math.cos(a);

		y1 = y0 - ll * Math.sin(a);

		// 右树枝点确定
		x2 = x0 + lr * Math.cos(-b);

		y2 = y0 - lr * Math.sin(b);

		// Scanner sc = new Scanner(System.in);
		// sc.nextLine();
		// System.out.println(x0 + "----" + y0);
		// System.out.println(x1 + "----" + y1);
		g.drawLine((int) x0, (int) y0, (int) x1, (int) y1);
		// System.out.println(x0 + "----" + y0);
		// System.out.println(x2 + "----" + y2);
		// sc.nextLine();
		g.drawLine((int) x0, (int) y0, (int) x2, (int) y2);

		// 划线——注意方法所需要的数据类型

		Show(x1, y1, ll * getLL(), lr * getLR(), a - Math.PI * getLeftangle()
				/ 180, b + Math.PI * getRightangle() / 180, count - 1, g);

		Show(x2, y2, ll * getLL(), lr * getLR(), a + Math.PI * getLeftangle()
				/ 180, b - Math.PI * getRightangle() / 180, count - 1, g);

		// 进行递归调用(注意传到方法里的点是相对于新正方形的右下点)

	}
}