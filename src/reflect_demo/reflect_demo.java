package reflect_demo;

/**
 * 反射知识demo 所有的类都是对象的实例 可以理解为通过创建的对象，返回查找对应的类，以及类的方法
 * */
public class reflect_demo {
	public void sayhello() {
		System.out.println("hello reflect");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reflect_demo d = new reflect_demo();
		String name = d.getClass().getName();
		try {
			String method_name = d.getClass().getMethod("sayhello", null)
					.getName();
			System.out.println("method name--" + method_name);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name);

	}
}
