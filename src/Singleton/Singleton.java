package Singleton;

public class Singleton {
	private static Singleton singleton;
	public String name;

	Singleton() {
		name = "hello world";
	}

	// 双重锁定
	public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
