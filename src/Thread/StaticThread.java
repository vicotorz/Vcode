package Thread;

/**
 * @author admin 2017年4月20日
 */
public class StaticThread {

	// synchronized修饰静态
	synchronized public static void printA() {
		try {
			System.out.println(
					"线程名称为:" + Thread.currentThread().getName() + "在  " + System.currentTimeMillis() + " 进入pringA()");
			Thread.sleep(3000);
			System.out.println(
					"线程名称为:" + Thread.currentThread().getName() + "在  " + System.currentTimeMillis() + " 离开pringA()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// synchronized修饰静态
	synchronized public static void printB() {
		try {
			System.out.println(
					"线程名称为:" + Thread.currentThread().getName() + "在  " + System.currentTimeMillis() + " 进入printB()");

			System.out.println(
					"线程名称为:" + Thread.currentThread().getName() + "在  " + System.currentTimeMillis() + " 离开printB()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// synchronized修饰非静态
	synchronized public void printC() {
		try {
			System.out.println(
					"线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 进入printC()");

			System.out.println(
					"线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 离开printC()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		StaticThread s = new StaticThread();
		ThreadA a = new ThreadA(s);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(s);
		b.setName("B");
		b.start();

		ThreadC c = new ThreadC(s);
		c.setName("C");
		c.start();

	}
}

class ThreadA extends Thread {
	private StaticThread s;

	public ThreadA(StaticThread s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		s.printA();
	}
}

class ThreadB extends Thread {
	private StaticThread s;

	public ThreadB(StaticThread s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		s.printB();
	}
}

class ThreadC extends Thread {
	private StaticThread s;

	public ThreadC(StaticThread s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		s.printC();
	}
}