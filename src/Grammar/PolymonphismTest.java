package Grammar;
/*
 * 为了理解多态继承方式
 * 1.调用的方法是子类的
 * 2.调用的属性是父类的
 * 
 * */
class Father {
	String flag = "Father";

	public void func1() {
		func2();
	}

	public void func2() {
		System.out.println("AAA");
	}
}

class Child extends Father {
	String flag = "Child";

	public void func1(int i) {// 应该调用这个方法，但是这个里面有个参数，因此调用不了。调用Father中的func2中的。
		System.out.println("BBB");
	}

	public void func2() {
		System.out.println("CCC");// 调用的这个方法
	}
}

public class PolymonphismTest {
	public static void main(String[] args) {
		Father child = new Child();
		child.func1();
		System.out.println(child.flag);
	}
}