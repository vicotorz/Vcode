package Grammar;

public class enumtest {
	public enum Out {
		one, two, three, four, five, six, seven, eight, nine, ten, eleven, tweleve
	};

	public static void main(String[] args) {
		Output(Out.seven);
	}

	private static void Output(Out s) {
		switch (s) {
		case one:
			System.out.println("31");
			break;
		case three:
			// System.out.println("31"); break;
		case five:
			System.out.println("31");
			break;
		case seven:
			System.out.println("31");
			break;
		case eight:
			System.out.println("31");
			break;
		case ten:
			System.out.println("31");
			break;
		case tweleve:
			System.out.println("31");
			break;
		case four:
			System.out.println("30");
			break;
		case six:
			System.out.println("30");
			break;
		case nine:
			System.out.println("30");
			break;
		case eleven:
			System.out.println("30");
			break;
		case two:
			System.out.println("29");
			break;
		default:
			System.out.println("wrong");
			break;
		}
	}
}
