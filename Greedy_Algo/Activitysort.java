import java.util.*;
public class Activitysort {
    public static int maxselectact(int[] start,int[]end){
        Arrays.sort(end);
        ArrayList<Integer>Actindex=new ArrayList<>();
        if(start.length<=1){
            Actindex.add(0);
            return start.length;
        }
        //select first activity
        int count=1;
        Actindex.add(0);
        int endTime=end[0];
        for(int i=1;i<end.length;i++){
            // select disjoint or unoverlaped activity
            if(endTime<=start[i]){
                Actindex.add(i);
                count+=1;
                endTime=end[i];
            }
        }
        System.out.println(Actindex);
        return count;
    }
    public static void main(String[] args) {
        int[]start={1,3,0,5,8,5};
        int[]end={2,4,6,7,9,9};
        System.out.println(maxselectact(start, end));
    }
    
}
