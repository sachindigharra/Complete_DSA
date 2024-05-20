import java.util.*;
public class Activityunsorted {
    public static int maxiselecting(int[]start,int[]end){
        ArrayList<Integer>Act=new ArrayList<>();
        if(start.length<=1){
            Act.add(0);
            return 1;
        }
        int count=0;
        int[][] activities=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
        Arrays.sort(activities,Comparator.comparingDouble(o ->o[2]));
        count=1;
        Act.add(activities[0][0]);
        int lastend=activities[0][2];
        for(int i=1;i<start.length;i++){
            
                if(activities[i][1]>=lastend){
                    count++;
                    Act.add(activities[i][0]);
                    lastend=activities[i][2];
                }
        }
        for(int i=0;i<Act.size();i++){
            System.out.print("A"+Act.get(i)+"  ");
        }
        System.out.println();
        return count;
    }
    public static void main(String[] args) {
        int[]start={1,3,0,5,8,5};
        int[]end={2,4,6,7,9,9};
        System.out.println(maxiselecting(start, end));
    }
}
