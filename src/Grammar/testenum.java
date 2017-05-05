package Grammar;
public class testenum {

	/**
	 * @param args
	 * 
	 * 
	 */

	public boolean isNumber(char c) {
		boolean flag = false;

		switch (c) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			flag = true;
			break;
		default:
			flag = false;
			break;
		}
		return flag;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testenum t = new testenum();
		System.out.println(t.isNumber('0'));

	}

}
