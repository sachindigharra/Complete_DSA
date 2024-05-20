public class Issorted {
    static boolean hasSorted(int[] nums,int i){
        if(i==nums.length-1)return true;
        if(nums[i]>nums[i+1])return false;
        return hasSorted(nums, i+1);
    }
    public static void main(String[] args) {
        int[]x={1,2,3,4,5,6,1};
        System.out.println(hasSorted(x, 0));
    }
}