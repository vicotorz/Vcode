package something_unfamiliar;

public class ThreadProblem implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}
	
	public static void main(String[] args) {
	   new ThreadProblem().run();
	   System.out.println("whiwhiwh");
	}

}
