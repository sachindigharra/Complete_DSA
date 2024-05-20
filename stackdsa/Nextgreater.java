import java.util.*;
public class Nextgreater {
    static int[] findNextgreater(int[] num){
        if(num.length<=1){
            return num;
        }
        Stack<Integer>s=new Stack<>();
        int[] res=new int[num.length];
        for(int i=num.length-1;i>=0;i--){
            while(!s.isEmpty()&& num[i]>=num[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i]=-1;
            }
            else{
                res[i]=num[s.peek()];
            }
            s.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] num={6,8,0,1,3};
        System.out.println(Arrays.toString(findNextgreater(num)));
    }
}
