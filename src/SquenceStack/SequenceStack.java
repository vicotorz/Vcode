package SquenceStack;
import java.util.Arrays;

public class SequenceStack {

	/**
	 * 2014.6.2
	 * 
	 * @param args
	 *            顺序栈的Java实现
	 * 
	 *            作者：张迪Victorz
	 * 
	 *            参考：李刚《疯狂Java程序员的基本修养》
	 * 
	 *            %思路：用数组结构实现,数组思路非常清晰容易实现(运行很成功！)
	 */
	// 保存数组的长度（可以自己更改）
	private int DEFAULT_SIZE = 1;

	// 定义当前底层数组容量不够时，每次增加的数组长度
	private int extendsize = 0;

	// 定义一个数组保存顺序栈
	private Object[] elementData;

	// 顺序栈中元素的个数(也可充当访问栈顶的记录部分)
	private int size = -1;

	// 默认数组长度创建空栈
	public SequenceStack() {
		extendsize = DEFAULT_SIZE;
		elementData = new Object[extendsize];

	}

	// 以初始化元素创建栈
	public SequenceStack(int size, Object element) {
		this.extendsize = size;
		elementData = new Object[extendsize];
		elementData[0] = element;
		size++;

	}

	// 以指定长度创建顺序栈

	// 获取顺序栈的大小
	public int getSize() {
		return size + 1;
	}

	// 栈是否为空的函数
	public boolean isEmpty() {
		return size == 0;
	}

	// 入栈操作
	public void push(Object element) {

		int i = size + 1;
		if (i > DEFAULT_SIZE - 1) {// 注意这里应该是减一的值，因为涉及到后来元素增加的扩展（else部分）
			// 扩展空间数目
			extendsize <<= 1;
			// 扩展空间
			elementData = Arrays.copyOf(elementData, extendsize);
			// 扩展后赋值
			size++;
			elementData[size] = element;

		} else {
			elementData[size + 1] = element;
			size++;
		}

	}

	// 出栈操作
	public Object pop() {
		// 是不是需要释放相应的内存空间
		Object item = elementData[size];
		elementData[size] = null;
		size--;
		return item;
	}

	// 取栈顶元素
	public Object peek() {
		return elementData[size];
	}

	// 清空顺序栈
	public void clear() {
		for (int i = size; i >= 0; i--) {
			pop();
		}
	}

	public void showall() {
		System.out.println("栈从栈顶到栈尾的元素情况");
		for (int i = size; i >= 0; i--) {
			System.out.print(i + ":" + elementData[i] + "  ");
		}
		if (size == -1) {
			System.out.print("顺序栈中没有元素!");
		}
		System.out.println();
	}

	// 计算给定数字串
	public void caculateString(String str) {
		
		
	}
}
