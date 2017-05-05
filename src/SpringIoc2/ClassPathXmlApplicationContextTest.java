package SpringIoc2;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ClassPathXmlApplicationContextTest implements BeanFactoryTest {

	private final Map<String, Object> beans = new HashMap<String, Object>();

	public ClassPathXmlApplicationContextTest() throws Exception {
		final SAXBuilder sb = new SAXBuilder();

		System.out.println("开始读取配置文件");
		final Document doc = sb.build(this.getClass().getClassLoader()
				.getResourceAsStream("./beans.xml"));

		final Element root = doc.getRootElement();
		final List list = root.getChildren("bean");
		// 获取xml节点
		for (int i = 0; i < list.size(); i++) {
			final Element element = (Element) list.get(i);
			final String id = element.getAttributeValue("id");
			final String clazz = element.getAttributeValue("class");
			final Object o = Class.forName(clazz).newInstance();
			System.out.println("bean id: " + id);
			System.out.println("bean class: " + clazz);
			beans.put(id, o);

			for (final Element propertyElement : (List<Element>) element
					.getChildren("property")) {
				final String name = propertyElement.getAttributeValue("name");
				final String bean = propertyElement.getAttributeValue("bean");
				System.out.println("property name: " + name);
				System.out.println("property bean: " + bean);
				final Object beanObject = beans.get(bean);

				// 重组方法名称
				final String methodName = "set"
						+ name.substring(0, 1).toUpperCase()
						+ name.substring(1);
				System.out.println("根据property name构造method name = "
						+ methodName);

				System.out.println("开始利用反射执行setter注入... ");
				final Method m = o.getClass().getMethod(methodName,
						beanObject.getClass().getInterfaces()[0]);
				m.invoke(o, beanObject);
			}
		}
	}

	@Override
	public Object getBean(String id) {
		return beans.get(id);
	}
}
