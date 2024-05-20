public class Maxpointobtain { 
    public static int maxScore(int[] nums, int k) {
        int leftSum=0;
        for(int i=0;i<k;i++){
            leftSum+=nums[i];
        }
        int sum =leftSum;
        int r=nums.length-1;
        int rightSum=0;
        for(int i=k-1;i>=0;i--){
            leftSum-=nums[i];
            rightSum+=nums[r];
            r--;
            sum=Math.max(sum,leftSum+rightSum);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[]cardPoints ={1,2,3,4,5,6,1};
        int k=3;
        System.out.println(maxScore(cardPoints, k));
    }
}
