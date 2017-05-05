package LinkList;
public class LinkList {

	/**
	 * 2014.6.1
	 * 
	 * @param args
	 *            单向链表的Java实现
	 * 
	 *            作者：张迪Victorz
	 * 
	 *            参考：李刚《疯狂Java程序员的基本修养》
	 * 
	 *            %思路：需要创建节点内部类，包括其中的节点和链表信息
	 * 
	 *            经验总结： 注意物理地址和逻辑地址，如果怕麻烦就用物理地址
	 * 
	 *            一定要思路清晰，这里的有些属性如果写成private的修饰，就会出现错误。因此这里所有属性都为public
	 * 
	 * 
	 */

	// 内部类Node代表Node节点
	/**
	 * 节点内部类
	 * */
	// 这里的pre和next都没有调用到，什么原因？？？内部类中属性的访问方法是什么
	public class Node {
		// 链表的实现
		public Object data;// 数据
		public Node next;// 指向下一个引用

		// 内部类中的默认构造方法无法访问

		public Node() {
			this.data = null;
			this.next = null;
		}

		// 初始化属性构造器
		public Node(Object element, Node next) {

			this.data = element;
			this.next = next;
		}

	}// 内部类结束

	/**
	 * 以上内部类结束
	 * */

	// 头结点
	public Node head;
	// 尾节点
	public Node tail;

	// 链表所含的节点数（物理地址）
	public int size;

	// 创建空链表，默认构造方法
	public LinkList() {
		head = new Node();
		tail = new Node();
		size = 0;
	}

	// 这个构造函数必须要有，因为这个函数负责与前一个Node的节点相连接不分
	public LinkList(Object element) {
		head = new Node(element, null);
		tail = head;
		size++;
	}

	/***********************************************************************************/

	// 方法函数的定义
	// 1.返回链表的长度
	public int getSize() {
		return size;
	}

	// 2.判断链表是否为空函数
	public boolean isEmpty() {
		return size == 0;
	}

	// 3.向链表中指定位置插入元素 (location就是指相关的物理位置)
	public void insert(int location, Object element) {
		// System.out.println("在物理位置" + location + "的地方插入值为" + element);
		if (location < 0 || location > size + 1) {
			System.out.println("操作错误！");
			throw new IndexOutOfBoundsException("越界操作！");
		} else {

			// 在特定的位置插入元素
			// 1.获取位置的前一个节点
			// 这里要考虑在已有链表的情况下，在首部添加的情况
			if (location == 0) {
				if (head.next == null) {// 这里必须这样判断head，判断head的next的值
					// System.out.println(element + "调用第一个部分");
					head.data = null;
					head.next = new Node(element, null);

				} else {
					Node newNode = new Node(element, head.next);// 创建当前节点
					head.next = newNode;
				}
			} else {
				Node current = head;
				Node pre = null;// pre为当前指向的Node
				the: for (int i = 0; i <= size; i++, current = current.next) {
					if (i == location - 1) {
						pre = current;// 当前节点的上一个节点为pre
						break the;
					}
				}

				// 这里的pre为当前节点的上一个节点
				Node newNode = new Node(element, pre.next);// 创建当前节点
				// 3.当前节点指向下一个节点
				pre.next = newNode;
			}
			tail = getlastNode();
			size++;
		}
	}

	// 4.获取最后一个节点，用于tail属性的赋值
	public Node getlastNode() {
		Node p = head;
		Node thatis = null;
		to: for (int i = 0; i <= size; i++) {

			if (p.next == null) {
				thatis = p;
				break to;
			} else {
				p = p.next;
			}
		}
		return thatis;

	}

	// 5.获取特定元素的位置
	public int getlocation(Object element) {
		int location = -1;
		Node current = head;
		for (int i = 0; i <= size && current.next != null; i++, current = current.next) {
			if (current.data == element) {
				location = i;
				return location;
			}
		}
		return location;

	}

	// 6.向链表中末尾位置插入元素
	public void add(Object element) {
		// 以知链表的长度为size，如果插入到链表的末尾，则放入到size+1的部分
		insert(size + 1, element);
	}

	// 7.向链表的头结点位置插入元素
	public void insertfirst(Object element) {
		insert(0, element);
	}

	// 8.删除指定位置的元素(涉及head和tail方面的变化)（location是指物理位置）
	public void deletespecic(int location) {
		// 删除的location的位置的范围一定在0~location的部分
		// head节点不能删除
		if (location <= 0 || location > size) {
			System.out.println("输入位置错误");
			throw new IndexOutOfBoundsException("输入位置错误");
		}

		Node current = head;
		Node pre = null;// pre为当前指向的Node
		the: for (int i = 0; i <= size; i++) {
			if (i == location - 1) {
				pre = current;// 当前节点的上一个节点为pre
			}
			if (i == location) {
				break the;
			}
			current = current.next;
		}
		// System.out.println("pre" + pre.data);
		// System.out.println("current" + current.data);
		pre.next = current.next;
		current.next = null;
		current.data = null;

		// 这里是不是应该把内存中这块没用的地方释放掉？？
		tail = getlastNode();
		size--;

	}

	// 9.删除末尾处的元素
	public void delspecific() {
		deletespecic(size);
	}

	// 10.清空链表
	public void clear() {
		for (int i = size; i > 0; i--) {
			delspecific();
		}
		head.data = null;
		head.next = null;
		tail.data = null;
		tail.next = null;
		size = 0;
		// 是不是应该各个删除内存？？？
	}

	// 11.展示数据
	public void showall() {
		System.out.println("------------展示所有信息-------------");
		Node current;
		int i;
		if (head.next != null) {
			current = head.next;
			i = 1;
		} else {
			current = head;
			i = 0;
		}
		if (i == 1) {
			for (; i <= size; i++) {
				System.out.println(current.data + "    ");
				current = current.next;

			}
		} else {
			System.out.println("链表暂时没有数据");
		}
		System.out.println();
	}

	/**
	 * 习题,用尽快的方法找到链表中倒数第K个位置的节点
	 * */

	public Node getKlocation(int k) {
		if (k > size) {
			System.out.println("错误输入");
			return null;
		}
		Node node1 = head;
		int i = 0;
		for (; i <= k; ++i) {
			node1 = node1.next;
		}
		Node node2 = head.next;
		while (i <= size) {
			node1 = node1.next;
			node2 = node2.next;
			i++;
		}
		return node2;

	}

	/**
	 * 习题,尽可能高效的实现序列的左移P
	 * */
	public void leftmove(int location) {
		// 计数就行
		Node cur = head.next;
		for (int i = 1; i < location; i++) {
			cur = cur.next;
		}
		Node last = getlastNode();
		last.next = head.next;
		head.next = cur.next;
		cur.next = null;

	}

}
