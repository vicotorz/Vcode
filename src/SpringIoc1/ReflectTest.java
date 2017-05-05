package SpringIoc1;

import java.lang.reflect.Field;

public class ReflectTest {

	private final String fname;

	private final String lname;

	public ReflectTest(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}

	public static void main(String[] args) {

		try {
			final ReflectTest rt = new ReflectTest("java", "aspectj");
			fun(rt);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void fun(Object obj) throws Exception {
		final Field[] fields = obj.getClass().getDeclaredFields();
		System.out.println("替换之前的:");
		for (final Field field : fields) {
			System.out.println(field.getName() + "=" + field.get(obj));
			if (field.getType().equals(java.lang.String.class)) {
				field.setAccessible(true);
				// 必须设置为 true 才可以修改成员变量
				final String org = (String) field.get(obj);
				field.set(obj, org.replaceAll("a", "b"));
			}
		}
		System.out.println("替换之后的：");
		for (final Field field : fields) {
			System.out.println(field.getName() + "=" + field.get(obj));
		}
	}
}