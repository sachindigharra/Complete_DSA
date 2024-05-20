
import java.util.ArrayList;
import java.util.List;

public class Majorityele {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer>ls=new ArrayList<>();
        int me=nums.length/3;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]==nums[i])count++;
            }
            if(count>me && ls.indexOf(nums[i])<0)ls.add(nums[i]);
        }
        return ls;
    }
    public static void main(String[] args) {
        int []nums={1,2,1,1,1,2,2,3,3,3,3};
        System.out.println(majorityElement(nums));
    }
}
