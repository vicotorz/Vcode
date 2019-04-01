package WangYi;

import java.util.Scanner;
 
public class Reference {
    static final int mod = 1000000007;
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] state = new int[n+1][k+1];
         
        state[0][1] = 1;
         
        //n长度以i结尾
        for(int i=1; i<=n; i++) {
        	System.out.println("长度为"+i);
            int sum = 0;
            for(int j=1; j<=k; j++) {
                sum = (sum + state[i-1][j]) % mod;
            }
            System.out.println("sum:"+sum);
            for(int j=1; j<=k; j++) {
                int invalid = 0;
                int p = 2;
                while(p*j <= k) {
                	//对不起，前一个状态中p*j位置所有合法的都不能算了
                    invalid = (invalid + state[i-1][p*j]) % mod;
                    p++;
                }
                System.out.println("invalid:"+invalid);
                state[i][j] = (sum - invalid + mod) % mod;
                System.out.println("state"+state[i][j]);
            }
        }
        for(int x=0;x<=n;x++){
        	for(int y=0;y<=k;y++){
        		System.out.print(state[x][y]+",");
        	}
        	System.out.println();
        }
        
        int sum = 0;
        for(int i=1; i<=k; i++) {
            sum = (sum + state[n][i]) % mod;
        }
        System.out.println(sum);
         
        scanner.close();
    }
}