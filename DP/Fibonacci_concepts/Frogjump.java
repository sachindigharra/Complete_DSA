import java.util.*;
public class Frogjump {
    // minimum energy requried to frog reach from 0 index t0 n-1
    // simple recursion Approach
    public static int minimumEnergy(int[]nums,int ind){
        if(ind==0)return 0;
        // frog take step =1
        int j1=Math.abs(nums[ind]-nums[ind-1])+minimumEnergy(nums, ind-1);
        // check frog can jump step and then junmp
        if(ind>1){
            int j2=Math.abs(nums[ind]-nums[ind-2])+minimumEnergy(nums, ind-2);
            return Math.min(j1,j2);
        }
        return j1;

    }
    // Dp using (top down)Memoization Approach
    public static int memoApp(int[]dp,int[]nums,int n){
        if(n==0)return 0;
        if(dp[n]!=-1){
            return dp[n];
        }
        int j1=Math.abs(nums[n]-nums[n-1])+memoApp(dp,nums, n-1);
        if(n>1){
            int j2=Math.abs(nums[n]-nums[n-2])+memoApp(dp,nums, n-2);
            dp[n]=Math.min(j1,j2);
            return dp[n] ;       
        }
        dp[n]=j1;
        return dp[n];
    }
    //Tabulation Approach 
    public static int tabApp(int[]nums,int ind){
        int[]dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<=ind;i++){
            int j1=Math.abs(nums[i]-nums[i-1])+dp[i-1];
            if(i>1){
                int j2=Math.abs(nums[i]-nums[i-2])+dp[i-2];
                dp[i]=Math.min(j1,j2);
            }
            else{
                dp[i]=j1;
            }
        }
        return dp[ind];
    }
    //no extra space Requried
    public static int noSapceTab(int[]nums,int ind){
        int prev=0;
        int prev2=0;
        for(int i=1;i<=ind;i++){
            int j1=Math.abs(nums[i]-nums[i-1])+prev;
            int j2=Integer.MAX_VALUE;
            if(i>1){
                j2=Math.abs(nums[i]-nums[i-2])+prev2;
            }
            prev2=prev;
            prev=Math.min(j1,j2);
        }
        return prev;
    }

   public static void main(String[] args) {
    int nums[]={30, 10, 60, 10, 60, 50 };
    int ind=nums.length-1;
    System.out.println(noSapceTab(nums, ind));

   } 
}
