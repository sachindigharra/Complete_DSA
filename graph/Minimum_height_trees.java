import java.util.*;
import java.util.LinkedList;
 
public class Minimum_height_trees {
    public static void bfs(ArrayList<Integer>[] adjList ,int ele,boolean[]vis,int[] minhieght,List<Integer>res ){
        Queue<Integer> q = new LinkedList<>();
        q.add(ele);
        int height=0;
        while(!q.isEmpty()){
            int sz=q.size();
            while (sz-->0) {
                int cur=q.remove();
                if(!vis[cur]){
                    //System.out.println(cur);
                    vis[cur]=true;
                    for(int i=0;i<adjList[ele].size();i++){
                        q.add(adjList[ele].get(i));
                    }
                }
            }    
            height++;
        }
        System.out.println(height+""+ele);
        if(height<minhieght[0]){
            res.clear();
            res.add(ele);
            minhieght[0]=height;
        }
        else if(height==minhieght[0])res.add(ele);
        
    }
    public static  List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>ls = new ArrayList<>();
        ArrayList<Integer>[] adjList = new ArrayList[n];
        int minhieght[]={Integer.MAX_VALUE};
        for(int i=0;i<n;i++){
            adjList[i]=new ArrayList<>();
        }
        for(int[]edge:edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        boolean[]vis=new boolean[n];
        for(int i=0;i<n;i++){
            
            bfs(adjList, i, vis, minhieght, ls);
            System.out.println(minhieght[0]);
        }

        return ls;
    }
    public static void main(String[] args) {
        int n=6;
        int[][]edges={{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(findMinHeightTrees(n, edges));
    }
    
}
