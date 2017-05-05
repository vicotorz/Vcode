package ThreadDemo;
//方法1.继承Thread类
public class E_Thread extends Thread {
	// run()方法
	String name;

	E_Thread(String name) {
		this.name = name;
	}

	// run方法
	public void run() {
		int i = 10;
		while (i >= 0) {
			System.out.print(this.name + " " + i + " ");
			i--;
		}
		try {
			sleep(1000);// 休眠时间
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new E_Thread("th1").start();
	}

}
