import java.util.Arrays;

public class Maxnonadj{
    //Memoization
    public static int memoApp(int[]nums,int ind,int[]dp){
        if(ind<0)return 0;
        if(ind==0)return nums[ind];
        if(dp[ind]!=-1)return dp[ind];
        int not_pick=memoApp(nums, ind-1, dp);
        int pick=nums[ind]+memoApp(nums, ind-2, dp);
         dp[ind]=Math.max(not_pick,pick);
            return dp[ind];
        
    
    }
    public static void main(String[] args) {
        int nums[] = {2, 1, 4, 9};
        
        // Get the length of the array.
        int n = nums.length;
        int[]dp=new int[n];
        Arrays.fill( dp,-1);
        System.out.println(memoApp(nums, n-1, dp));
    }
}