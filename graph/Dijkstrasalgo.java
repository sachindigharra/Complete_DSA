import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstrasalgo{
    static class  Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            src=s;
            dest=d;
            wt=w;
        }
    
    }
    static class  Pair implements Comparable<Pair> {
        int n;
        int path;
        public Pair(int _n,int _path){
            n=_n;
            path=_path;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.path-p2.path;
        }
    }
     static void createGraph(int v,ArrayList<Edge> Graph[]){
        for(int i=0;i<v;i++){
            Graph[i]=new ArrayList<>();
        }
        Graph[0].add (new Edge( 0,  1,  2)); 
        Graph [0]. add (new Edge( 0,  2,  4));
        Graph [1] .add (new Edge( 1,  3,  7)); 
        Graph [1]. add (new Edge( 1,  2,  1));
        Graph [2]. add (new Edge( 2,  4,  3));
        Graph [3] .add (new Edge( 3,  5,  1));
        Graph [4]. add (new Edge( 4,  3,  2)); 
        Graph [4]. add (new Edge( 4,5,5));
      
    }
    static int[] Dijkstras(ArrayList<Edge>[]Graph,int src){
        // visited Array to track Node
        boolean vis[]=new boolean[Graph.length];
        // distance array store src from src;
        int[]dis=new int[Graph.length];
        for(int i=0;i<Graph.length;i++){
            if(src!=i){
                dis[i]=Integer.MAX_VALUE;// store +infinity
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr=pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true; 
                for(int i=0;i<Graph[curr.n].size();i++){
                    Edge e=Graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dis[u]+wt<dis[v]){

                        dis[v]=dis[u]+wt;

                        // add node in pq with updated distance
                        pq.add(new Pair(v, dis[v]));

                    }
                }
            }

            
        }
        return dis;
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge>[]Graph=new ArrayList[v];
       
        createGraph(v, Graph);
        // shortest Path

        for(int i:Dijkstras(Graph,0)){
            System.out.print(i+" ");
        }
    }
}