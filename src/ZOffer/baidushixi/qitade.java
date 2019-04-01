package baidushixi;

import java.util.Scanner;

public class qitade {
    static int n = 0;
    static int k = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[][] ans = new int[n+1][n+1];
        for(int i=2;i<=n;i++){
            ans[i][0] = 1;
            ans[i][i-1] = 1;
        }
        for(int i=3;i<=n;i++){
            for(int j=1;j<i-1;j++){
                ans[i][j] = (ans[i-1][j-1]*(i-j) + ans[i-1][j]*(j+1))%2017;
            }
        }
        System.out.println(ans[n][k]);
        sc.close();
    }
 
}
