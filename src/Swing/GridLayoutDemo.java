package Swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GridLayoutDemo extends JFrame implements ActionListener {
	private static final Object[] JButton = null;
	private JButton buttons[];
	private String names[] = { "blue", "cyan", "black", "green", "magenta",
			"orange", "pink", "red", "white", "yellow" };

	private Container container;
	private GridLayout grid2;
	private Component button;

	public GridLayoutDemo() {
		super("��ɫ��");
		grid2 = new GridLayout(5, 2);
		container = getContentPane();
		container.setLayout(grid2);
		buttons = new JButton[names.length];
		for (int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this);
			container.add(buttons[count]);
		}
		setSize(500, 250);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == buttons[0]) {

			buttons[0].setBackground(Color.blue);
		}
		if (event.getSource() == buttons[1]) {

			buttons[1].setBackground(Color.cyan);
		}
		if (event.getSource() == buttons[2]) {

			buttons[2].setBackground(Color.green);
		}
		if (event.getSource() == buttons[3]) {

			buttons[3].setBackground(Color.magenta);
		}
		if (event.getSource() == buttons[4]) {

			buttons[4].setBackground(Color.orange);
		}
		if (event.getSource() == buttons[5]) {
			buttons[5].setBackground(Color.pink);
		}
		if (event.getSource() == buttons[6]) {
			buttons[6].setBackground(Color.red);
		}
		if (event.getSource() == buttons[7]) {
			buttons[7].setBackground(Color.pink);
		}
		if (event.getSource() == buttons[8]) {
			buttons[8].setBackground(Color.white);
		}
		if (event.getSource() == buttons[9]) {
			buttons[9].setBackground(Color.yellow);
		}

	}

	public static void main(String args[]) {
		GridLayoutDemo application = new GridLayoutDemo();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
