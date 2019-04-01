package testjdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCexercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("加载驱动成功！");

			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");

			System.out.println("连接成功！");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into JDBC (id,idnumber) values(2,50)");
			System.out.println("添加成功!");
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动不成功！");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接不成功！");
			e.printStackTrace();
		}
	}

}
