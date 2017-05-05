package Test;
/**
 * 打印   
 * 
 
 *
***
*****
*******
*****
****
***
**
*
  
 * 
 * **/

public class BFJAVA1 {

	public static void main(String[] args) {
		for (int i = 1; i <= 4; i++) {

			for (int y = 0; y < 2 * i - 1; y++) {
                
				System.out.print("*");
				
			}

			System.out.println();

		}

		for (int x = 5; x >0; x--) {
			for (int u = 1;u<=x; u++) {
				System.out.print("*");
			}
			System.out.println();

		}
	}
}
