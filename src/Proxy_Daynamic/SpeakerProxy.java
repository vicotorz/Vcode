package Proxy_Daynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SpeakerProxy implements User {

	User user;

	@Override
	public void say() {
		// TODO Auto-generated method stub
		user.say();
	}
	
	//动态代理
	SpeakerProxy(User user) {
		this.user=user;
		//动态代理主要使用了newProxyInstance
		//ClassLoader loader：指定当前目标对象使用类加载器，写法固定
		//Class<?>[] interfaces：目标对象实现的接口的类型，写法固定
		//InvocationHandler h：事件处理接口，需传入一个实现类，一般直接使用匿名内部类
		User proxy = (User) Proxy.newProxyInstance(
				user.getClass().getClassLoader(), //classloader
				user.getClass().getInterfaces(), //interfaces
				new InvocationHandler() {//handler
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return method.invoke(proxy, args);
			}
		});
		
		user.say();
	}
	
	
	
	public static void main(String[] args) {
		new SpeakerProxy(new Speaker());
	}

}
