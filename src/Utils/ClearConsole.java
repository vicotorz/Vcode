package Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ClearConsole {
	public static void clear() throws AWTException {
		Robot r = new Robot();
		r.mousePress(InputEvent.BUTTON3_MASK); // 按下鼠标右键
		r.mouseRelease(InputEvent.BUTTON3_MASK); // 释放鼠标右键
		r.keyPress(KeyEvent.VK_CONTROL); // 按下Ctrl键
		r.keyPress(KeyEvent.VK_R); // 按下R键
		r.keyRelease(KeyEvent.VK_R); // 释放R键
		r.keyRelease(KeyEvent.VK_CONTROL); // 释放Ctrl键
		r.delay(1000);

	}

	public static void say() {
		System.out.println("NiHao");
	}

	public static void say2() {
		try {
			clear();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("你好");
	}

	public static void main(String[] args) {
		try {
			say();
			say2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
