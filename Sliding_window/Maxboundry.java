import java.util.ArrayDeque;

public class Maxboundry {
    
    public  static long numberOfSubarrays(int[] nums) {
        long res=0;
        // we treat array deque as Stack
        ArrayDeque<int[]>stack=new ArrayDeque<>();
        for(int ele:nums){
            while(!stack.isEmpty() && stack.peek()[0]<ele){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek()[0]!=ele)stack.push(new int[]{ele,0});
            res+=++stack.peek()[1];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums={1,4,3,3,2};
        System.out.println(numberOfSubarrays(nums));
    }
}
