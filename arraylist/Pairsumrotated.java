
import java.util.*;
public class Pairsumrotated {
    // Given ArrayList is Sorted then rotated;
    // Two Pointer Approach
    // Optimze code
    //Modular Function use in traversal
    public static boolean isContainSum(ArrayList<Integer>ls,int target){
        int n=ls.size();
       int b=-1;
        for(int i=0;i<ls.size()-1;i++){
            if(ls.get(i)>ls.get(i+1)){
                b=i;
                break;
            }
        }
        int lp=b+1;
        int rp=b;
        while(lp!=rp){
            if(ls.get(lp)+ls.get(rp)==target)return true;
            if(ls.get(lp)+ls.get(rp)<target)lp=(lp+1)%n;
           else{
            rp=(n+rp-1)%n;
           }

        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer>ls=new ArrayList<>();
        ls.add(4);
        ls.add(5);
        ls.add(1);
        ls.add(2);
        ls.add(3);
        
        System.out.println(isContainSum(ls, 5));
    }
}
