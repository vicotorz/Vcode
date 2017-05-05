package SpringIoc1;

import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Dom读取xml
 * */
public class JdomSample {

	public static void main(String[] args) throws Exception {

		final SAXBuilder sb = new SAXBuilder();
		final Document doc = sb.build(JdomSample.class.getClassLoader()
				.getResourceAsStream("file:///{/All/src/SpringIoc1/test.xml}")); // 构造文档对象

		final Element root = doc.getRootElement(); // 获取根元素HD
		final List list = root.getChildren("disk");// 取名字为disk的所有元素
		for (int i = 0; i < list.size(); i++) {

			final Element element = (Element) list.get(i);
			final String name = element.getAttributeValue("name");
			final String capacity = element.getChildText("capacity");// 取disk子元素capacity的内容
			final String directories = element.getChildText("directories");
			final String files = element.getChildText("files");

			// 打印输出
			System.out.println("磁盘信息:");
			System.out.println("分区盘符:" + name);
			System.out.println("分区容量:" + capacity);
			System.out.println("目录数:" + directories);
			System.out.println("文件数:" + files);
			System.out.println("-----------------------------------");

		}
	}
}