public class Targetsum {
    public static boolean targetSumTab(int[]nums,int target){
        int n=nums.length;
        boolean[][]dp=new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
       
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                int v=nums[i-1];
                // valid && include
                if(v<=j &&dp[i-1][j-v]==true){
                    //include
                    dp[i][j]=true;
                   
                }
                else if(dp[i-1][j]){
                    dp[i][j]=true;
                }
            }
        }
        return dp[n][target];
    }
    public static void main(String[] args) {
        int[]nums={4,2,7,1,3};
        int target=10;
        System.out.println(targetSumTab(nums, target));
    }
     
}
