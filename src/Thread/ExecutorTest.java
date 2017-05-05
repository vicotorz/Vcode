package Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorTest {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
				.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executor.execute(new task());
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
			System.out.printf(
					"Pool size:%d,Active count:%d,Completed Task:%d\n",
					executor.getPoolSize(), executor.getActiveCount(),
					executor.getCompletedTaskCount());
		}
	}

}

class task implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is called");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
