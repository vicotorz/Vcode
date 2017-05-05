package Test;
/**
 *打印 

   *   
  ***  
 ***** 
*******
 ***** 
  ***  
   *   

 * **/
public class BFJAVA2 {
	public static void main(String[] args) {
		for (int x = 1; x <= 4; x++) {
			for (int y = 1; y <= 7; y++) {
				if (y <= 4 - x || y >= 4 + x) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}

			}
			System.out.println();

		}

		for (int e = 1; e <= 3; e++) {
			for (int q = 1; q <= 7; q++) {
				if (q <= e || q >= 8 - e)
					System.out.print(" ");
				else {
					System.out.print("*");
				}

			}
			System.out.println();

		}
	}

}
