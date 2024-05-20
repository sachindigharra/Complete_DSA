import java.util.*;
public class Max_rectangle_in_2d {
    private static int largestRectangleArea(int[] x) {
        int max=0;
        int n=x.length;
        int[] nsr=new int[n];
        int[] nsl=new int[n];
        Stack<Integer>s=new Stack<>();
        // next smaller right
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty()&& x[s.peek()]>=x[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=n;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        //next smaller Left
        s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty()&& x[s.peek()]>=x[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        //calculate Area -> Width=nsr[i]-nsl[i]-1
        for(int i=0;i<n;i++){
            int Heights=x[i];
            int Width=nsr[i]-nsl[i]-1;
            int CurrentArea=Heights*Width;
            max=Math.max(CurrentArea,max);
        }
        return max;
    }
    public  static int maximalRectangle(char[][] mat) {
        int max=Integer.MIN_VALUE;
        int n=mat[0].length;
        int[]x=new int[n];
        int i=0;
        while(i<mat.length){
            for(int j=0;j<n;j++){
                if(mat[i][j]=='0')x[j]=0;
                else{
                    x[j]=1+x[j];
                }
            }
            max=Math.max(max,largestRectangleArea(x));
            i++;
        }
        return max;
    }
    public static void main(String[] args) {
        char[][]matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
    
}
