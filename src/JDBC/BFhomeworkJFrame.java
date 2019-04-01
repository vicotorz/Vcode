package testjdbc;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BFhomeworkJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fd1 = new JTextField(15);
	private JPasswordField fd2 = new JPasswordField(15);
	private JPanel panel3 = new JPanel();
	private JButton button1 = new JButton("注册");
	private JButton button2 = new JButton("重置");
	private Statement stmt;
	private ResultSet rs;
	PreparedStatement pst;
	Connection conn;

	int r = 0;

	private JFrame frame = new JFrame();

	public BFhomeworkJFrame() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载成功！");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			System.out.println("连接成功！");
			stmt = conn.createStatement();

		} catch (ClassNotFoundException e) {

			System.out.println("加载失败");
			// e.printStackTrace();
		} catch (SQLException e) {

			System.out.println("连接失败");
			// e.printStackTrace();
		}

		JLabel label0 = new JLabel("登陆界面");
		JLabel label1 = new JLabel("用户名：");
		JLabel label2 = new JLabel("密码：");

		JPanel panel0 = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		frame.setLayout(new GridLayout(4, 1));
		frame.setTitle("注册表单");
		panel0.add(label0, CENTER_ALIGNMENT);
		panel1.add(label1);
		panel1.add(fd1);
		panel2.add(label2);
		panel2.add(fd2);
		panel3.add(button1);
		panel3.add(button2);
		frame.add(panel0);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});


		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (r % 2 == 0) {

					String str11 = new String(fd2.getPassword());
					String sql = "insert into userinfo (name,password)"
							+ "values('" + fd1.getText() + "','" + str11 + "')";
					try {
						stmt.executeUpdate(sql);
					} catch (SQLException e1) {
						System.out.println("注册错误!");
					}
					JOptionPane.showMessageDialog(null, "注册成功！");
					reset();
					button1.setText("登录");
					r++;
				} else {

					try {
						pst = conn
								.prepareStatement("select name,password from userinfo where name=? and password=?");
						String str12 = new String(fd2.getPassword());
						pst.setString(1, fd1.getText());
						pst.setString(2, str12);
						rs = pst.executeQuery();

						if (rs.next() == true) {
							JOptionPane.showMessageDialog(null, "登陆成功！");
							reset();
							button1.setText("注册");
							r++;
						} else if (rs.next() == false) {
							JOptionPane.showMessageDialog(null, "登录失败！");
							reset();
						}
					} catch (HeadlessException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "登录失败！");
						fd1.requestFocus();
					}

				}

			}
		});
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void reset() {
		fd1.setText("");
		fd2.setText("");
		fd1.requestFocus();

	}

	public static void main(String[] args) {

		new BFhomeworkJFrame();

	}

}
