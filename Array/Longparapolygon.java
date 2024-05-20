
import java.util.*;;
public class Longparapolygon {
    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long par=0;
        if(nums[0]+nums[1]>=nums[2]){
            par=nums[0]+nums[1]+nums[2];
        }
        if( nums.length==3){
            if(par==0)return -1;
            return par;
        }
        for(int i=3;i<nums.length-2;i++){
            if(par==0){
                if(nums[i]+nums[i+1]>=nums[i+2]){
                    par=nums[i]+nums[i+1]+nums[i+2];
                }
                i=i+2;
            }
            else{
                if(nums[i-1]+nums[i-2]>=nums[i]){
                    par+=nums[i];
                }
            }

        }
        return par;
    }
    public static void main(String[] args) {
        int[]nums = {1,1,2};
        System.out.println(largestPerimeter(nums));
    }
}
