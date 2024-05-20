import java.util.*;
import java.util.LinkedList;

public class Safe_state {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
       // we have to calCulate indeg in khan topology but For terminal we need Out degree 
        // so if reverse the Graph indegree -> Out degree
        List<List<Integer>>revadj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            revadj.add(new ArrayList<>());
        }
        int[]indeg=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;i++){
                revadj.get(graph[i][j]).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        List<Integer>ls=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            ls.add(curr);
            for (int it : revadj.get(curr)) {
                indeg[it]--;
                if (indeg[it] == 0) q.add(it);
            }
        }
           Collections.sort(ls);
           return ls;
    }
    public static void main(String[] args) {
        
    }
}
