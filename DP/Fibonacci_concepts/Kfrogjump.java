import java.util.*;
public class Kfrogjump {
    // simple Recursion Approach& Memoization

    public static int memoApp(int[] nums,int ind,int k,int[]dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1)return dp[ind];
        int mmsteps=Integer.MAX_VALUE;
         for(int j=1;j<=k;j++){
            if(ind-j>=0){
                    int jump=Math.abs(nums[ind]-nums[ind-j])+ memoApp(nums, ind-j, k,dp);
                    mmsteps=Math.min(jump,mmsteps);
            }
         }
         dp[ind]=mmsteps;
         return dp[ind];
    }
    // Tabulation 
    public static int tabulationApp(int[]nums,int k){
        int []dp=new int[nums.length];
        dp[0] = 0;
        int n=nums.length;

        // Loop through the array to fill in the dp array
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;

            // Loop to try all possible jumps from '1' to 'k'
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(nums[i] - nums[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1];
    }
    
    public static void main(String[] args) {
        int nums[]={30, 10, 60, 10, 60, 50 };
       int k=2;
       System.out.println(tabulationApp(nums, k));
      
    }
}
