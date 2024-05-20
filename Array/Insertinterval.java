import java.util.*;
public class Insertinterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        boolean insert=false;
        if(n==0){
            intervals=new int [1][2];
            intervals[0][0]=newInterval[0];
            intervals[0][1]=newInterval[1];
            return intervals;
        }
        List<Integer>ls=new ArrayList<>();
        int flag=newInterval[1];
        for(int i=0;i<n;i++){
            
            if(intervals[i][1]>=newInterval[0]&& flag>intervals[i][1]){
                insert=true;
                intervals[i][1]=flag;
                for(int j=i+1;j<n;j++ ){
                    if(flag>intervals[j][0]){
                        ls.add(j);
                    }
                    else if(flag==intervals[j][0]){
                        intervals[i][1]=intervals[j][1];
                        flag=intervals[j][1];
                        ls.add(j);
                    }
                }
                break;
            }
            
        }
        if(!insert && intervals[n-1][1]<newInterval[0]){
            int[][]res=new int[n+1][2];
            int k=0;
            for(int i=0;i<n;i++){
    
                res[k][0]=intervals[i][0];
                res[k][1]=intervals[i][1];
                k++;
            }
            res[k][0]=newInterval[0];
            res[k][1]=newInterval[1];
            return res; 
        }
        
        int[][]res=new int[n-ls.size()][2];
        int k=0;
        for(int i=0;i<n;i++){
            if(ls.indexOf(i)==-1){
                res[k][0]=intervals[i][0];
                res[k][1]=intervals[i][1];
                k++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][]mat={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int []x={4,8};
        int[][]res=insert(mat, x);
        for(int[] it:res){
            for(int i:it){
                System.out.print(i);
            }
            System.out.println();
        }

    }
}
