public class Prosubarr{
    static int count=0;
    private static void helper(int[]nums,int i,int pro,int k){
        if(i>=nums.length || pro>=k)return;
        
        pro=pro*nums[i];
        if(pro<k)count++;
        helper(nums, i+1, pro, k);
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            helper(nums, i, 1, k);
        }
        return count;
    }
    public static void main(String[] args) {
        int[]nums = {1,1,1};
        int k=2;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}