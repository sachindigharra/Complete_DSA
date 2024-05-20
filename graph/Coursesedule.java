import java.util.*;


public class Coursesedule {
    public static boolean canFinish(int n, int[][] pre) {
        if(n==0)return true;
        int[]indeg=new int[n];
        // calculate Indeg for respective Node or vertex
        for(int i=0;i<pre.length;i++){
            indeg[pre[i][0]]++;
        }
        Queue<Integer>q=new LinkedList();
        // search for Vertex whose indeg is zero becasue it is independent from all vertex
        for(int i=0;i<n;i++){
            if(indeg[i]==0)q.add(i);
        }
        int count=0;
        while(!q.isEmpty()){
            count++;
            int curr=q.poll();
           
            for(int i=0;i<pre.length;i++){
                if(pre[i][1]==curr){
                    indeg[pre[i][0]]--;
                    if(indeg[pre[i][0]]==0)q.add(pre[i][0]);
                }
            }
            
        }
        return n==count;
    }
    public static void main(String[] args) {
        int n=2;
        int[][]pre={{1,0},{0,1}};
        System.out.println(canFinish(n,pre));
    }
}
