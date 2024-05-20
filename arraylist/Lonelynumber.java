import java.util.*;

public class Lonelynumber {
    public static List<Integer> findLonely(int[] nums) {
        List<Integer> ls=new ArrayList<>();
        if(nums.length==1){
            ls.add(nums[0]);
            return ls;
        }
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=1;i<n-1;i++){
            if(nums[i-1]+1<nums[i] && nums[i]+1<nums[i+1]){
                ls.add(nums[i]);
            }
            
        }
        if(nums[0]+1<nums[1]){
            ls.add(nums[0]);
        }
        if(nums[n-1]>nums[n-2]+1){
            ls.add(nums[n-1]);
        }
        return ls;
    }
    public static void main(String[] args) {
        int[]nums={10,6,5,8};
        System.out.println(findLonely(nums));
    }
}
