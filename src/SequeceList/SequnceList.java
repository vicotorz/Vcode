package SequeceList;

import java.util.Arrays;

public class SequnceList {

	/**
	 * 2014.6.1
	 * 
	 * @param args
	 *            线性表的Java实现
	 * 
	 *            作者：张迪Victorz
	 * 
	 *            参考：李刚《疯狂Java程序员的基本修养》
	 * 
	 * 
	 *            %线性表是指用一组连续的存储单元按存储线性表的元素，用数组结构实现
	 */
	private int DEFAULT_SIZE = 16;// 定义长度
	private int capacity;// 默认长度
	private Object[] elementData;// 定义一个数组
	private int size = 0;// 当前的长度

	// 创建线性链表（默认构造函数）
	SequnceList() {// 构造相应的线性表
		capacity = DEFAULT_SIZE;//
		elementData = new Object[capacity];

	}

	// 以一个初始值来创建线性链表
	public <T> SequnceList(T element) {
		this();
		elementData[0] = element;
		size++;
	}

	// 获取线性链表的大小
	public int getSize() {
		return size;

	}

	// 获取线性链表在位置1处的数据
	public Object getFirstElement() {
		return elementData[0];
	}

	// 查找线性链表在指定位置处的元素
	public Object getSpecificElement(int location) {
		if (location - 1 > size || location < 0) {
			System.out.println("大小有误!");
			return null;
		} else {
			return elementData[location - 1];
		}

	}

	// 获取线性链表在指定元素处的索引
	public <T> int getIndex(T element) {
		int thelocation = -1;
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(element)) {
				thelocation = i;
			}
		}
		return thelocation;
	}

	// 扩充数组的长度(性能比较差)
	// @SuppressWarnings("unused") 屏蔽潜在的错误，对被批注的代码元素内部的某些警告保持静默。
	private void extendarry(int extendsize) {
		if (extendsize > capacity) {
			while (capacity < extendsize) {// 数位数，扩展几位
				capacity <<= 1;// 移位赋值
			}
			elementData = Arrays.copyOf(elementData, capacity);// 将数组扩展!!!
		}
	}

	// 向线性链表指定位置处插一个元素
	public <T> void insert(int location, T element) {

		if (location < 0 || location > size + 1) {
			System.out.println("输入错误！");
			throw new IndexOutOfBoundsException("越界");
		} else {
			// 实质上是在location的位置上插入

			// 向后移动
			extendarry(size + 1);
			System.arraycopy(elementData, location, elementData, location + 1,
					size - location);// !!

			// 插入
			elementData[location] = element;
			size++;
		}

	}

	// 在线性链表结尾处增加一个元素(与指定位置的情况相差不多)，但这个操作简单
	public <T> void add(T element) {
		insert(size, element);
	}

	// 遍历现有的线性链表
	public void showall() {
		for (int i = 0; i < size; i++) {
			System.out.print(elementData[i] + "  ");
		}
		System.out.println();
	}

	// 删除指定索引位置处的元素
	public <T> void delete(int location) {
		if (location < 0 || location > size + 1) {
			System.out.println("输入错误！");
			throw new IndexOutOfBoundsException("越界");
		} else {

			// 删除
			/*
			 * 演算： 如果有数组
			 * 
			 * 0 1 2 3
			 * 
			 * i w e q 删除第二个w
			 * 
			 * size=4，location=1 size-location-2=1
			 */
			// 这里size为逻辑位置，location为物理位置，numMoved为物理位置

			int numMoved = (size - (location)) - 1;// 确定位置,物理位置
			// 移动
			// 不懂!!!!!!!!!!!!!!!!!!
			if (numMoved > 0) {
				System.arraycopy(elementData, location + 1, elementData,
						location, numMoved);
			}
			elementData[--size] = null;

		}
	}

	// 删除线性链表最后一个元素
	public void deltelast() {
		delete(size - 1);
	}

	// 判断线性链表是否为空
	public boolean isempty() {
		return size == 0;

	}

	// 清空线性表
	public void clear() {
		// Arrays.fill(elementData, null);//也可以利用Arrays中的函数，将所有元素都添加为null
		for (int i = 0; i < size - 1; i++) {
			elementData[i] = null;
		}
		capacity = 0;// 将长度置为0
	}

}
