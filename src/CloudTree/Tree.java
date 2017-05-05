package CloudTree;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;

public class Tree extends JFrame {

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

		Tree a = new Tree();

		a.draw();

	}

	public void draw() {// 绘制窗体，添画布

		this.setSize(1000, 700);//

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(3);

		this.setVisible(true);
		this.setBackground(Color.white);
		Graphics g = this.getGraphics();

	}

	// 画出边框
	public void paint(Graphics g) {
		// System.out.println("paint");
		// Scanner sc = new Scanner(System.in);
		// sc.next();
		super.paint(g);

		// 调用show函数
		g.drawLine((int) 500, (int) 400, (int) 500, (int) 300);
		this.Show(500, 300, 100, Math.PI * 45 / 180, Math.PI * 45 / 180, 5, g);

		// (Math.PI为180°)

	}

	// 给出对应的左偏量，左树枝长，右偏量，右树枝长即可
	public void Show(double x0, double y0, double l, double a, double b,
			double count, Graphics g) {

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
		x1 = x0 - l * Math.cos(a);

		y1 = y0 - l * Math.sin(a);

		// 右树枝点确定
		x2 = x0 + l * Math.cos(-b);

		y2 = y0 - l * Math.sin(b);

		Scanner sc = new Scanner(System.in);
		// sc.nextLine();
		System.out.println(x0 + "----" + y0);
		System.out.println(x1 + "----" + y1);
		g.drawLine((int) x0, (int) y0, (int) x1, (int) y1);
		System.out.println(x0 + "----" + y0);
		System.out.println(x2 + "----" + y2);
		// sc.nextLine();
		g.drawLine((int) x0, (int) y0, (int) x2, (int) y2);

		// 划线——注意方法所需要的数据类型

		Show(x1, y1, l * 0.5, a - Math.PI * 45 / 180, b + Math.PI * 45 / 180,
				count - 1, g);

		Show(x2, y2, l * 0.5, a + Math.PI * 45 / 180, b - Math.PI * 45 / 180,
				count - 1, g);

		// 进行递归调用(注意传到方法里的点是相对于新正方形的右下点)

	}
}