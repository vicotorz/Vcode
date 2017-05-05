package Test;

public class whatoutput {

	/**
	 * @param args

	 * 
	 */
	public static void change(String name){
		name="world";
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="Hello";
		change(a);
		System.out.print(a);

	}

}
