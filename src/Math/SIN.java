package Math;
import java.math.BigDecimal;

public class SIN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double i = 60;
		BigDecimal re = new BigDecimal(Math.cos(i * Math.PI / 180)).setScale(2,
				BigDecimal.ROUND_HALF_UP);

		System.out.println(re);

	}

}
