public class Numberofnicesubarr {
    public static int subArrayWithMostkOddNo(int[]nums,int k){
        int i=0;
        int ans=0;
        int count=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]%2!=0)count++;
            while(count>k && i<=j){
                if(nums[i]%2!=0)count--;
                i++;
            }
            ans=ans+(j-i+1);

        }
        return ans;
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        // no of subarray in which no of odd if At most k
        int noddk=subArrayWithMostkOddNo(nums, k);
        // no of subarray in which  no of odd no at most k-1
        int noodlessk=subArrayWithMostkOddNo(nums, k-1);
        return noddk-noodlessk;
    }
    public static void main(String[] args) {
        int[]nums={2,2,2,1,2,2,1,2,2,2};
        int k=2;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
