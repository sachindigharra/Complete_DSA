import java.util.*;
public class Pairsum{
    // nums is Sorted ArrayList 
    public static boolean isContainSum(ArrayList<Integer>ls,int target){
        if(ls.size()<2)return false;
        int lp=0;
        int rp=ls.size()-1;
        while(lp<rp){
            if(ls.get(lp)+ls.get(rp)==target)return true;
            if(ls.get(lp)+ls.get(rp)<target)lp++;
           else{
            rp--;
           }

        }
        return false;
    }
 public static void main(String[] args) {
    ArrayList<Integer>ls=new ArrayList<>();
    ls.add(1);
    ls.add(2);
    ls.add(3);
    ls.add(5);
    System.out.println(isContainSum(ls, 5));
        

 }   
}