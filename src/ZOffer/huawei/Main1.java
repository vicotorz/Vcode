package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。 【处理】
 * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
 * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 * 3.输入的文件可能带路径，记录文件名称不能带路径
 * 
 * 【输入描述】 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。 文件路径为windows格式
 * 如：E:\V1R2\product\fpgadrive.c 1325
 * ============================================
 * ==================================
 * ==================================================== 【输出描述】
 * 将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
 * 结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。【稳定排序】 如果超过8条记录，则只输出前8条记录.
 * 如果文件名的长度超过16个字符，则只输出后16个字符
 * 
 * 【输入例子】 E:\V1R2\product\fpgadrive.c 1325
 * 
 * 
 * 【输出例子】 fpgadrive.c 1325 1
 **/

class Main1 {
	// 如果长度超过16个字符，将只输出后16个字符
	public String subfile(String filename) {
		String subString = null;
		if (filename.length() > 16) {
			subString = filename.substring(filename.length() - 17, filename.length() - 1);
		} else {
			subString = filename;
		}
		return subString;
	}

	public static void main(String[] args) {
		Main1 m = new Main1();
		Scanner sc = new Scanner(System.in);
		HashMap<String, errorlog> map = new HashMap<String, errorlog>();
		;
		while (sc.hasNext()) {
			String key = sc.nextLine();
			String[] path = key.split(" ");
			String[] fileitems = path[0].split("\\");
			String loc = path[1];
			String filename = m.subfile(path[path.length - 1]);
			// HashMap的结构 String 类对象

			// 检查加入的是否存在
			errorlog er = map.get(key);

			if (er == null) {
				// 如果不存在
				map.put(key, new errorlog(key, 1));
			} else {
				// 如果存在,错误增加
				er.number++;
			}

		}

		// 开始排序 根据错误的数目多少【按照errorlog的错误信息排序】
		// 完全不会的地方
		ArrayList<errorlog> list = new ArrayList<errorlog>(map.values());

		// 不会的地方
		Comparator<errorlog> cpt = new Comparator<errorlog>() {

			@Override
			public int compare(errorlog o1, errorlog o2) {
				return o2.number - o1.number == 0 ? o1.queueMark - o2.queueMark : o2.number - o1.number;
			}
		};
		// 自定义比较器
		Collections.sort(list, cpt);

		// 取出前八个
		int len = 8 > list.size() ? list.size() : 8;
		for (int i = 0; i < len; i++) {
			errorlog er = list.get(i);
			// 输出格式 文件 loc 次数
			System.out.println(list.get(i).name + " " + list.get(i).number);
		}
	}
}

// 一个类中的平行类
// 错误日志
class errorlog {
	static int mark;// 辅助自增
	public int queueMark;// 标记出现的位置
	public String name;
	public int number;

	public errorlog() {
		super();
	}

	public errorlog(String name, int number) {
		super();
		queueMark = mark++;
		this.name = name;
		this.number = number;
	}

	public static int getMark() {
		return mark;
	}

	public static void setMark(int mark) {
		errorlog.mark = mark;
	}

	public int getQueueMark() {
		return queueMark;
	}

	public void setQueueMark(int queueMark) {
		this.queueMark = queueMark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
