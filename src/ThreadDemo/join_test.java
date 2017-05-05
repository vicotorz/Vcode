package ThreadDemo;
/*
 * join()方法是插入线程
 * 
 * */
public class join_test {

	private Thread th1;// 继承了Thread
	private Thread th2;// 实现了Runnable接口

	join_test() {

		th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i = 0;
				// 如果i>5让th2运行结束，再进行
				while (i <= 10) {
					System.out.println("th 1--" + i);
					if (i == 5) {
						try {
							th2.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					i++;
				}

			}
		});
		
		th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int y = 0;
				while (y < 3) {
					System.out.println("th2--" + y);
					y++;
				}

			}

		});
		//th1.setPriority(7);
	    th1.start();// 开始th1线程
		//th2.setPriority(7);
		th2.start();// th2线程开始
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new join_test();

	}

}
