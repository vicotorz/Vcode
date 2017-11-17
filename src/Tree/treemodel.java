package Tree;
import java.util.ArrayList;

public class treemodel {

	/**
	 * 2014.6.10开始写
	 * 
	 * 2014.6.21晚修改
	 * 
	 * 普通树的Java实现
	 * 
	 * 作者：张迪Victorz
	 * 
	 * 参考：李刚《疯狂Java程序员的基本修养》
	 * 
	 * %用一个节点数组保存树里面的节点，并让每个节点记录其父节点所在的组的索引即可（类似于主键和从建）
	 * 
	 * 节点的维护有两种方法
	 * 
	 * 1.维护父节点（找子节点很麻烦） 让每个节点都记住自己的父节点
	 * 
	 * 2.维护子节点，让父节点记住子节点（类似临街链表的方式）
	 * 
	 * 3.针对二叉树，（因为确定了子节点的个数 1 or 2 ）采用数组就能实现存储
	 * 
	 * 4.二叉树 还可有二叉树链表存储 【左指针】【数据】【右指针】
	 * 
	 * 5.二叉树 还有进一步的链表存储 【父节点指针】【左指针】【数据】【右指针】
	 * 
	 * %%涉及二叉树的先序遍历 中序遍历 后序遍历
	 * 
	 * 暂时选用链表存储 【父节点指针】【左指针】【数据】【右指针】结构,默认从左插入
	 * 
	 * 
	 * 出现的问题：
	 * 
	 * 1.开始插入的时候由于模糊，只能实现在根节点的插入。后来改为利用标号来插入
	 * 
	 * 2.遍历知识混乱
	 */
	SequenceQueue que = new SequenceQueue();

	// 节点内部类
	public class Node {
		public Node father;// 父节点// 记录父节点的位置
		public Node leftch;// 左节点
		public Node rightch;// 右节点
		public Object data;// 存储的数据

		// 所有元素的构造方法
		public Node(Node father, Node leftch, Node rightch, Object data) {
			super();
			this.father = father;
			this.leftch = leftch;
			this.rightch = rightch;
			this.data = data;
		}

		// 默认构造方法
		public Node() {

		}

		public Node(Node leftch, Node rightch, Object data) {
			super();
			this.leftch = leftch;
			this.rightch = rightch;
			this.data = data;
		}

		// 构造尾节点
		public Node(Object data, Node father) {
			super();
			this.father = father;
			this.data = data;
		}

	}

	// 一些属性
	private int nodenum;// 节点的个数
	private int height;// 记录树的高度
	private Node root;// 永远指向根节点

	// private Node avli;

	// 初始建立树

	// 一些getter和setter方法
	public int getNodenum() {
		return nodenum;
	}

	public void setNodenum(int nodenum) {
		this.nodenum = nodenum;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// 默认构造方法
	treemodel() {
		if (root == null) {
			root = new Node(null, null, null, null);
			setHeight(1);// 高度为1
			setNodenum(1);// 设置节点为1
		}
	}

	treemodel(Object data) {
		if (root == null) {
			root = new Node(null, null, data);
			setHeight(1);// 高度为1
			setNodenum(1);// 设置节点为1
		}
	}

	// 构造方法以指定的根节点和内容来创建树
	treemodel(Node speroot, Object data) {
		// 找到这个根节点，返回根节点

		try {
			Node node = find(speroot);
			if (node != null) {
				// 插入节点
				add(data, node);

			} else {
				throw new Exception("没找到相关的根节点");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		// 然后在这个根结点处插入相关的节点

	}

	// 为指定节点添加子节点(在father的节点插入节点，数据为data,默认从左面插入)
	public void add(Object data, Node father) {
		try {
			// 查找这个根节点是否存在

			if (!ishasrightnode(father)) {
				// 插入左节点
				father.leftch = new Node(father, null, null, data);
				nodenum++;
				height = (int) Math.floor(nodenum / 2) + 1;
			} else if (!isfull(father)) {
				// 插入右节点
				father.rightch = new Node(father, null, null, data);
				nodenum++;
				height = (int) Math.floor(nodenum / 2) + 1;
			} else {
				throw new Exception("对不起，此根节点不能插入");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// 判断节点是否有左节点
	public boolean ishasrightnode(Node node) {
		boolean flag = false;
		if (node.leftch != null) {
			flag = true;
		}
		return flag;
	}

	// 判断给定根节点是否两个子节点都被占满
	public boolean isfull(Node node) {
		boolean flag = false;
		if (node.leftch != null && node.rightch != null) {
			flag = true;
		}
		return flag;
	}

	// 判断树是否为空
	public boolean isEmpty() {
		return nodenum == 1;
	}

	// 返回根节点函数
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	// 查找并返回特定的节点
	// 遍历节点开始寻找
	// 递归调用
	public Node find(Node node) {
		System.out.println(node.data);

		Node t = getRoot();
		find(t.leftch);
		find(t.rightch);
		if (t.data == node.data && t.leftch == node.leftch
				&& t.rightch == node.rightch) {
			return t;

		}
		return null;
	}

	// 主要用于查找插入的地方,用于编号
	public Node find2(int location) {
		Node ro = getRoot();
		try {
			if (location > nodenum) {
				throw new Exception("超出范围");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		for (int i = 1; i <= location;) {
			if (ro.leftch != null) {
				ro = ro.leftch;
				i++;
			} else if (ro.rightch != null) {
				ro = ro.rightch;
				i++;
			} else {
				ro = ro.father;
			}
		}
		return ro;

	}

	// 删除相关的节点

	public void delete(Node node) { // 找到这个点，如果有子节点，顺便把节点删下去
		if (node == null) {
			return;
		}
		delete(node.leftch);
		delete(node.rightch);

		{
			node.data = null;
			node.leftch = null;
			node.rightch = null;
			if (leftorright(node).equals("left")) {
				node.father.leftch = null;
			} else {
				node.father.rightch = null;
			}
		}

	}

	// 判断节点是其父节点的左节点还是右节点
	public String leftorright(Node node) {
		if (node.father.leftch == node) {
			return "left";
		} else {
			return "right";
		}

	}

	// 修改相关的节点
	public void update(int i, Object data) {
		Node spe = find2(i);
		spe.data = data;

	}

	// 返回指定节点的父节点
	public Node returnfathernode(Node node) {
		return node.father;

	}

	// 返回树的高度
	public int height() {
		return height;
	}

	// 返回包含指定值的节点
	public ArrayList<Node> returnNodes(Object data) {
		ArrayList<Node> list = new ArrayList<Node>();
		Node t = getRoot();
		find(t.leftch);// 左递归
		find(t.rightch);// 右递归
		if (t.data == data) {
			list.add(t);// 将有特定值的点放入到线性表中
		}
		return list;
	}

	// 遍历所有树中的节点，用于查找和核对
	public void showall(Node cur) {

		// 采用先序序列遍历树(也可采用中序和后序)

		if (cur == null) {
			return;
		}
		System.out.println(cur.data);
		showall(cur.leftch);
		showall(cur.rightch);

	}

	// 层次便利实现部分
	/**
	 * 在编写这个的时候思路很清晰，但是在关于队列部分的时候出现越界，重复添加的问题都得到的妥善的解决
	 * */
	public void specialsearch(Node node) {
		// 传入的节点为树的根节点
		if (node == root) {
			que.add(node);
		}
		Node remnode = que.remove();// 出队
		System.out.println("出队的节点" + remnode.data);

		if ((Node) remnode.leftch != null && (Node) remnode.rightch != null) {
			que.add((Node) remnode.leftch);
			que.add((Node) remnode.rightch);
			specialsearch((Node) remnode.leftch);
			specialsearch((Node) remnode.rightch);
		} else

		if ((Node) remnode.leftch != null) {
			// 如果队列出来的点左子节点不为空，向队列中加入这个点
			que.add((Node) remnode.leftch);
			specialsearch((Node) remnode.leftch);

		} else

		if ((Node) remnode.rightch != null) {
			// 如果队列出来的点右子节点不为空，向队列中加入这个点
			que.add((Node) remnode.rightch);
			specialsearch((Node) remnode.rightch);
		}

		// 递归出口,如果队列为空，层次遍历结束（有点特殊，因为是特殊的树）
		if (que.isEmpty()) {
			return;
		}

	}

	/**
	 * 练习：在给定 先跟序列 和 中跟序列 的情况下构建树
	 * */

	public int size(int start, int end) {
		// start为序列开始的地方，keyroot为关键值(先跟)
		return end - start + 1;

	}

	// 找到值的位置
	public int getloc(Object keyroot, Object B[]) {
		int i = 0;
		Object[] array = B;
		for (; i <= array.length; i++) {
			if (array[i] == keyroot) {
				return i;
			}
		}
		return i;

	}

	/*
	 * public void establishtree(Object A[], Object B[], int start, int end) {//
	 * 传入先跟序列和中跟序列
	 * 
	 * // 先跟的序列就是确定跟节点是谁 // 中跟的序列用来分左右子树的情况
	 * 
	 * // 确定中序中左子树的开始的地方，和大小 // 确定中序中右子树的开始的地方，和大小
	 * 
	 * // 流程 // -->遍历先跟的节点-->在中跟序列中找到这个点，划分左后子树-->确定左右子树的范围 //
	 * -->在先跟中划分左右子树（先跟序列部分确定顺序 1.先确定跟 2.确定左子树 3.确定右子树）
	 * 
	 * // 第一次和其他次区别对待 // -------------------------------------------------
	 *//**
	 * 第一次划分
	 */
	/*
	 * // 中跟的跟的位置 int locat = getloc(A[0], B);
	 * 
	 * // 中跟的左子树 int leftstart2 = 0; int leftend2 = locat - 1;
	 * 
	 * // 中跟的右子树 int rightstart2 = locat + 1; int rightend2 = B.length;
	 * 
	 * int leftsize = size(leftstart2, leftend2); int rightsize = leftsize +
	 * size(rightstart2, rightend2);
	 * 
	 * // 先跟左子树划分范围 int leftstart1 = 1; int leftend1 = leftstart1 + leftsize -
	 * 1; // 先跟右子树划分范围 int rightstart1 = leftend1 + 1; int rightend1 =
	 * rightstart1 + rightsize - 1; //
	 * -------------------------------------------------------
	 *//**
	 * 其他次划分
	 * */
	/*
	 * // 流程-->根据先跟两个子树两个第一个节点-->去中跟找到位置-->中跟划分子树-->先跟划分子树 // 1.找到位置
	 * getloc(A[leftend1], B); getloc(A[rightstart2], B);
	 * 
	 * // 2.确定范围 //中跟左集 establishtree(A, B, 0, getloc(A[leftend1], B) - 1);
	 * 
	 * //中跟右集 establishtree(A, B, getloc(A[leftend1], B) + 1, B.length);
	 * 
	 * // 3.递归调用
	 * 
	 * 
	 * 
	 * // 递归出口，如果这个节点左右都没有邻居，递归到头了
	 * 
	 * // 分两种情况 // 1.跟在其左边 // 2.跟在其右边
	 * 
	 * }
	 */

	// 返回建立完跟节点

	// 思路：就是建立中跟，不要想偏了，否则很复杂
	// l1和r1为pre左范围和右范围
	// l2和r2为in左范围和右范围

	// 真不好想！！！！！！
	// 反思：递归思想不成熟，界限方面确实有点绕
	public Node establishtree(Object pre[], Object in[], int l1, int r1,
			int l2, int r2) {
		if (l1 > r1)
			return null;
		Node node = new Node();
		node.leftch = node.rightch = null;
		int i = 0;
		for (; i < in.length; i++) {
			if (in[i] == pre[l1])
				break;
		}
		node.data = in[i];

		node.leftch = establishtree(pre, in, l1 + 1/* pre左子树左边界 */, l1 + i
				- l2/* pre左子树右边界 */, l2/* in左子树左边界 */, i - 1/* in左子树右边界 */);// ??

		node.rightch = establishtree(pre, in, l1 + i - l2 + 1/* pre左子树左边界 */,
				r1/* pre左子树右边界 */, i + 1/* in左子树左边界 */, r2/* in左子树右边界 */);

		return node;

		//

	}
}
