package SpringIoc2;

public class HumenTest {

	public void testHumen() throws Exception {

		final ClassPathXmlApplicationContextTest ctx = new ClassPathXmlApplicationContextTest();

		final Human human = (Human) ctx.getBean("human");

		// Car car = (BMWCar)ctx.getBean("car");

		// human.setCar(car);
		System.out.println("setter注入完成，开始执行测试 ");
		human.myCarRun();
	}

	public static void main(String[] args) {
		try {
			new HumenTest().testHumen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}