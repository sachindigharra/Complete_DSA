import java.util.*;
public class Mingreaterelement3 {
    public static int nextGreaterElement(int n) {
        System.out.println("working");
        List<Integer>ls = new ArrayList<>();
        int x=n;
        while(x>0){
            ls.add(x%10);
            x=x/10;
        }
        Collections.reverse(ls);
    
        int l=ls.size()-1;
        int r=ls.size()-1;
        while(l>-1 && r>-1){
            if(ls.get(l)<ls.get(r)){
                System.out.println("we caught it");
               
                int temp=ls.get(l);
                ls.set(l,ls.get(r));
                ls.set(r,temp);
               String str="";
                for(int it:ls){
                    str+=it;
                }
                System.out.println(str);
                int y= Integer.parseInt(str);
                r--;
                if(y>n)return y;
            }
            if(ls.get(l)>ls.get(r)){
                r--;
            }
            l--;
        }
        return -1;
    }
    public static void main(String[] args) {
        int n=105;
        System.out.println(nextGreaterElement(n));
    }
}
