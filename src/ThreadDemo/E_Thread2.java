package ThreadDemo;
/*
 * runnable 实现了资源共享
 * */
public class E_Thread2 implements Runnable {
	String name;

	E_Thread2(String name) {
		this.name = name;
	}

	// run方法
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);// 休眠时间
			System.out.println("run!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Thread(new E_Thread2("th1")).start();

	}

}
