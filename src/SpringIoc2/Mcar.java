package SpringIoc2;

public class Mcar implements Car {
	private final String MyBrand = "小黄车";

	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return MyBrand;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(MyBrand + "  is runnning!");
	}

}
