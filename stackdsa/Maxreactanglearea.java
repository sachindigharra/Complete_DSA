import java.util.*;
public class Maxreactanglearea {
    public static int largestRectangleArea(int[] heights) {
        int max=Integer.MIN_VALUE;
        int n=heights.length;
        // next Small right element
        int[]nsr=new int[n];
        // next small Left element
        int[]nsl=new int[n];
        Stack<Integer>s=new Stack<>();
        for(int i=n-1;i>=0;i-- ){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty())nsr[i]=n;
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        s=new Stack<>();
        for(int i=0;i<n;i++){
            while (!s.isEmpty() && heights[s.peek()]>=heights[i]) {
                s.pop();
            }
            if(s.isEmpty())nsl[i]=-1;
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
            
        }
        for(int i=0;i<n;i++){
            int Hieght=heights[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=Hieght*width;
            max=Math.max(max,currArea);
        }
        return max;
    }
    public static void main(String[] args) {
        int []heights={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
