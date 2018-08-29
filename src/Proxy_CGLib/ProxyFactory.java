package Proxy_CGLib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
//CGlib中不用再维护interface
public class ProxyFactory implements MethodInterceptor{

	//维护对象
	private Object user;
	
	public ProxyFactory(Object user) {
		// TODO Auto-generated constructor stub
		this.user=user;
	}
	
	//创建代理对象
	public Object getProxyInstance() {
		//1.工具类
		Enhancer en= new Enhancer();
		//2.设置父类
		en.setSuperclass(user.getClass());
		//3.设置回调函数
		en.setCallback(this);
		//4.创建子类（代理对象）
		return en.create();
	}
	

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] args, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		return arg1.invoke(user, args);
	}
	
	public static void main(String[] args) {
		//目标对象
		User target=new User();
		//代理对象
		User proxy=(User)new ProxyFactory(target).getProxyInstance();
		proxy.say();
	}

}
