import java.util.*;

public class Primsalgo {
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
        int node;
        int cost;
        public Pair(int _node,int _cost){
            node=_node;
           cost=_cost;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.cost-p2.cost;
        }
    }
     static void createGraph(int v,ArrayList<Edge> Graph[]){
        for(int i=0;i<v;i++){
            Graph[i]=new ArrayList<>();
        }
        Graph [0] .add (new Edge( 0,  1,  10)); 
        Graph [0]. add (new Edge( 0,  2,  15));
        Graph [0]. add (new Edge( 0,  3,  30));


        Graph [1]. add (new Edge( 1,  3, 40));
        
        Graph [3]. add (new Edge( 3,  2,  50));
    }
    public static int Prims(ArrayList<Edge>[]Graph){
        boolean[]vis=new boolean[Graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int finalcost=0;
        pq.offer(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            if(!vis[curr.node]){
                    vis[curr.node]=true;
                    finalcost+=curr.cost;
                    for(int i=0;i<Graph[curr.node].size();i++){
                        Edge e=Graph[curr.node].get(i);
                        pq.add(new Pair(e.dest, e.wt));
                    }
            }
        }
        return finalcost;
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge>[]Graph=new ArrayList[v];
       
        createGraph(v, Graph);
        System.out.println(Prims(Graph));
    }
}
