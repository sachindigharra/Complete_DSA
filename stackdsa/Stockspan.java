import java.util.*;
public class Stockspan {
    static void setSpan(int[]stock,int []span){
        // Store index of 
        Stack<Integer>S=new Stack<>();
        span[0]=1;
        S.push(0);
        for(int i=1;i<stock.length;i++){
            int currprice=stock[i];
            while(!S.isEmpty()&& currprice>stock[S.peek()]){
                S.pop();
            }
            if(S.isEmpty()){
                span[i]=i+1;
            }
            else{
                int prevhigh=S.peek();
                span[i]=i-prevhigh;
            }
            S.push(i);
        }
    }
    public static void main(String[] args) {
        int []stock={100,80,60,70,60,85,100};
        int []span=new int[stock.length];
        setSpan(stock, span);
        System.out.println(Arrays.toString(span));
    }
    
}
