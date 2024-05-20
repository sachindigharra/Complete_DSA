public class Maxcontinueone {
    public static  int longestOnes(int[] nums, int k) {
        int len=Integer.MIN_VALUE;
        int n=nums.length;
        int l=0;
        int r=0;
        int count=0;
        while(r<n){
            if(nums[r]==0) count++;

            while(count>k){
                if(nums[l] == 0) count--;
                l++;
            }
            len=Math.max(len, (r-l)+1);
            r++;
        }
        return len;
    }
    public static void main(String[] args) {
        int[]nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        System.out.println(longestOnes(nums, k));
    }
}
