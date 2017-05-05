package SpringIoc0;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射通用dao的写法
 * **/
public class CommonDao {
	public void dao(Object o) {
		try {
			Class c = o.getClass();// 得到对象的基本定义
			Field[] fs = c.getDeclaredFields();// 得到属性
			Method[] ms = c.getDeclaredMethods();// 得到方法

			// 通用dao的实现 拼接sql语句
			StringBuffer sql = new StringBuffer("insert into ");
			StringBuffer sql2 = new StringBuffer("");
			StringBuffer sql3 = new StringBuffer("");
			sql = sql.append("tablename" + "(");

			for (Field f : fs) {
				sql = sql.append(f.getName());
				sql.append(",");
				Method m = c.getDeclaredMethod(
						sql2.append(
								("get"
										+ Character.toUpperCase(f.getName()
												.charAt(0)) + f.getName()
										.substring(1))).toString(),
						new Class[0]);
				System.out.println(m);
				String rs = (String) m.invoke(o, new Object[0]);
				System.out.println(rs);
				sql3.append(rs);
				sql3.append(",");
				sql2 = new StringBuffer("");
			}
			// 以上拼接属性
			sql = new StringBuffer(sql.substring(0, sql.length() - 1));
			sql = sql.append(") values(");
			// 以下拼接值
			sql3 = new StringBuffer(sql3.substring(0, sql3.length() - 1));// 方法名

			sql = sql.append(sql3);
			sql = sql.append(")");
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		CommonDao d = new CommonDao();
		d.dao(new Book("Java", "10"));
	}

}
