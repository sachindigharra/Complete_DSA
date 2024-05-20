import java.util.*;
public class Minimum_pair {
    public static int minimumAbsDifferencePair(int[]a,int[]b){
        Arrays.sort(a);
        Arrays.sort(b);
        int minDiff=0;
        for(int i=0;i<a.length;i++){
                minDiff+=Math.abs(a[i]-b[i]);
        }
        return minDiff;
    }
    public static void main(String[] args) {
        int[]a={4,1,8,7};
        int[]b={2,3,6,5};
        System.out.println(minimumAbsDifferencePair(a, b));
        
    }
}
