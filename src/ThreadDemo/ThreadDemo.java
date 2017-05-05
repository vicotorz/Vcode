package ThreadDemo;

public class ThreadDemo implements Runnable {//继承Runnable接口

	/**
	 * @param args
	 * 简单的线程例子，可以简单学习一下（JAVA课件上的）
	 * 1.java语言中实现线程是获得Thread实例，并重写run()方法
	 * 2.Thread方法   interrupt()              中断线程
	 *              join()                   等待线程终止
	 *              sleep(long millis)       休眠时间
	 *              start()                  启动线程
	 *              run()                    执行线程体
	 *              wait()                   线程等待（多用wait()和notifyAll()实现协作）
	 *              isAlive()                是否处于活跃状态
	 *              isInterrupted()          测试线程是否已经终端
	 *              getPriority()            返回线程优先级
	 *              getState                 线程状态
	 *              setPriority()            设置优先级
	 *              currentThread()          当前线程
	 * 3.继承Thread(直接new Thread然后start())
	 *   继承Runnable接口方式 （创建实例后，需要在Thread中添加相关实例）
	 * 4.设置同步synchronized 
	 *  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo thread=new ThreadDemo();
		Thread t1=new Thread(thread);
		Thread t2=new Thread(thread);
		t1.start();
		t2.start();
		while((t1.isAlive()||t2.isAlive()))
			;
		System.out.println("The threaddemo is end");
	}
 public void run(){
	 String name=Thread.currentThread().getName();
	 show(name);
	 System.out.println("The"+name+"is dead!");
 }
 public synchronized void show(String name){//这里用synchronized对show方法进行上锁
	 for(int i=1;i<=5;i++){
		 System.out.println(name+"run");	 
	 }
 }
}
