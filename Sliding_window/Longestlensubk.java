import java.util.HashMap;

public class Longestlensubk{
    public static int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int left=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int r=0;r<nums.length;r++){
            // get all possilble subarray unitl freq of elements sholud <=k
            map.put(nums[r],map.getOrDefault(nums[r], 0)+1);
            while(map.get(nums[r])>k){
                // reduce the size of sliding Window
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
            max=Math.max(max,(r-left)+1);
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums={5,5,5,5,5,5,5};
        int k=4;
        System.out.println(maxSubarrayLength(nums, k));
    }
}