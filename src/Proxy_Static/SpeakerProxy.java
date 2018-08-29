package Proxy_Static;

public class SpeakerProxy implements UserInterface{
	
	UserInterface user;
    
    public SpeakerProxy(UserInterface user) {
    	this.user=user;
    }

	@Override
	public void say() {
		// TODO Auto-generated method stub
		//通过接口调用
		user.say();
	}
	
	
	public static void main(String[] args) {
		//静态代理：实现类与代理类实现接口，通过调用代理类，传入实现类调用方法
		new SpeakerProxy(new Speaker()).say();
	}

}
