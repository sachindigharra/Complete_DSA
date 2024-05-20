import java.util.*;
public class Climbstair {
   
    public static int recursionApp(int n){
        if(n<0)return 0;
        if(n==0)return 1;
        
        return recursionApp(n-1)+ recursionApp(n-2);
    }
    public static int memoizationApp(int n,int[]dp){
        if(n==0)return 1;

        if(n<0)return 0;
        
        if(dp[n]!=-1)return dp[n];
        dp[n]=memoizationApp(n-1, dp)+memoizationApp(n-2, dp);
        return dp[n];
    }
    public static int tabulationApp(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1]+0;
            }
            else{
                dp[i]=dp[i-2]+dp[i-1];
            }
        }
        return dp[n];
    }
    // Dynamic Approach Without any Extra Spaces
    public static int dpSpace(int n){
        int curr=1;
        int prev=1;
        for(int i=2;i<=n;i++){
            int temp=prev;
            prev=curr;
            curr=curr+temp;
        }
        return curr;
    }
public static void main(String[] args) {
    int n=44;
     int[] dp=new int[n+1];
     Arrays.fill(dp,-1);
        System.out.println(memoizationApp(n, dp));
        System.out.println(tabulationApp(44));
        System.out.println(dpSpace(5));
    }
}
