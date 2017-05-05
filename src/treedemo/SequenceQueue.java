package treedemo;
import java.util.Arrays;

public class SequenceQueue {
	/**
	 * 2014.6.2
	 * 
	 * @param args
	 *            顺序队列的Java实现
	 * 
	 *            作者：张迪Victorz
	 * 
	 *            参考：李刚《疯狂Java程序员的基本修养》
	 * 
	 *            %思路：用数组结构实现,数组思路非常清晰容易实现(运行很成功！)
	 */

	// 保存数组点的长度
	private int DEFUALT_SIZE = 1;

	// 定义一个数组用于保存元素
	private Object[] elementData;
	// 保存顺序队列中元素的个数
	private int size = -1;

	private int extendsize;

	// 以默认数组长度创建队列
	public SequenceQueue() {
		extendsize = DEFUALT_SIZE;
		elementData = new Object[extendsize];
	}

	// 以一个初始元素来创建队列
	public SequenceQueue(Object element) {
		extendsize = DEFUALT_SIZE;
		elementData = new Object[extendsize];
		elementData[0] = element;
		size++;
	}

	// 获取队列的大小
	public int getSize() {
		return size + 1;
	}

	// 队列是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 插入队列
	public void add(treemodel.Node element) {
		// 在相应的队尾增加即可
		int i = size + 1;
		if (i > DEFUALT_SIZE - 1) {
			extendsize <<= 1;
			elementData = Arrays.copyOf(elementData, extendsize);
			elementData[++size] = element;
		} else {
			elementData[++size] = element;

		}
	}

	// 移出队列
	public treemodel.Node remove() {
		// 移除过程涉及到元素的向后转移，有些麻烦

		// 开始移动
		treemodel.Node node = (treemodel.Node) elementData[0];
		elementData[0] = null;
		for (int i = 0; i + 1 <= size; i++) {
			elementData[i] = elementData[i + 1];
		}
		elementData[size] = null;
		size--;
		return node;

	}

	// 返回列顶元素(刚进来的元素)
	public Object peak() {
		return elementData[size];
	}

	// 返回列尾元素(在队列中最老的元素)
	public Object old() {
		return elementData[0];
	}

	// 清空队列
	public void clear() {
		int number = size;
		for (int i = 0; i <= number; i++) {
			remove();// 将其中的值多次弹出队列,间接实现清空的效果功能
		}

	}

	// 展示队列
	public void showall() {
		System.out.println("按元素进入队列的顺序开始输出");
		for (int i = 0; i <= size; i++) {
			System.out.println(elementData[i] + "  ");
		}
		if (size == -1) {
			System.out.print("顺序栈中没有元素!");
		}
		System.out.println();
	}

}
