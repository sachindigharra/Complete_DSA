import java.util.*;
public class Knapsack {
    //simple recursion
    public static int recuApp(int[]val,int[]wt,int W,int n){
        if(n==0){
             return ((int) (W / wt[0])) * val[0];
        }
       
        int not_take=recuApp(val, wt, W, n-1);// Exclude
        if(wt[n]<=W){
            int take=recuApp(val, wt, W-wt[n], n)+val[n];//include
            return Math.max(not_take,take);
        }
        return not_take;

    }
    // Memoization Approach
    public static int memoApp(int[]val,int[]wt,int W,int n,int[][]dp){
        if(n==0){
             return ((int) (W / wt[0])) * val[0];
        }
       if(dp[n][W]!=-1){
        return dp[n][W];
       }
        int not_take=memoApp(val, wt, W, n-1,dp);// Exclude
        if(wt[n]<=W){
            int take=memoApp(val, wt, W-wt[n], n,dp)+val[n];//include
            dp[n][W]= Math.max(not_take,take);
            return dp[n][W];
        }
         dp[n][W]=not_take;
        return dp[n][W];
    }

    // Tabulation Approach
    public static int tabApp(int[]val,int[]wt,int n,int W){
        int[][]dp=new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=W;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max((val[i-1]+dp[i][j-wt[i-1]]),dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
               System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][W];
    }
    
   public static void main(String[] args) {
    int wt[] = { 2,5,1,3,4 };
    int val[] = { 15,14,10,45,30 };
    int W = 7;

    int n = wt.length;
    int[][]dp=new int[n][W+1];
    for (int row[] : dp)
    Arrays.fill(row, -1);
    System.out.println(tabApp(val, wt, n, W));
   }

}
