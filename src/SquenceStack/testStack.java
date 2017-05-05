package SquenceStack;
public class testStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SequenceStack sta = new SequenceStack();
		sta.showall();

		sta.push("zhangdi");
		sta.push("vic");
		sta.push("I love you");

		sta.showall();

		System.out.println("栈顶第一个元素" + sta.peek());
		System.out.println("是否为空？" + sta.isEmpty());
		System.out.println("顺序栈的元素大小" + sta.getSize());

		System.out.println("出栈");
		String a = (String) sta.pop();
		System.out.println(a);
		String b = (String) sta.pop();
		System.out.println(b);
		sta.push("test");

		sta.showall();
		System.out.println("------开始清空栈中的元素--------------");
		sta.clear();
		sta.showall();

	}

}
