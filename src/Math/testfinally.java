package Math;

public class testfinally {
	testfinally(){
		System.out.println("调用了");
	}

	/**
	 * program test
	 * (int)
	 * %
	 * finally
	 * 语法
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//new testfinally();
			long temp=(int)3.9;
			System.out.println(temp);
			temp%=2;
			System.out.println(temp);
			return;
		}
		finally{
			System.out.println("finally");
		}

	}

}
