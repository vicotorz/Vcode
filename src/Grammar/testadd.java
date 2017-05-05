package Grammar;

public class testadd {
public static void main(String[] args) {
	couter a=new couter();
	System.out.println(a.increment());
	System.out.println(a.anotherIncrement());
	couter b=new couter();
	System.out.println(b.increment());
}
}

class couter{
	private int count=0;
	public int increment(){
		return count++;
	}
	public int anotherIncrement(){
		return ++count;
	}
	
}