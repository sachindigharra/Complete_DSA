import java.util.*;
import java.util.LinkedList;



public class Cheapflight {
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
    static class  Pair  {
        int node;
        int cost;
        int stop;
        public Pair(int _node,int _cost,int _stop){
            node=_node;
           cost=_cost;
           stop=_stop;
        }
       
    }
    public static void createGraph(int[][] flights,ArrayList<Edge>[]Graph){
        for(int i=0;i<Graph.length;i++){
            Graph[i]=new ArrayList<>(); 
        }
        for(int i=0;i<flights.length;i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt=flights[i][2];
            Edge e=new Edge(src, dest, wt);
            Graph[src].add(e);
        }
    }
    public static int cheaptestFlight(int n,int[][] flights,int src,int dest,int k){
       
        ArrayList<Edge>[]Graph= new ArrayList[n];
        createGraph(flights, Graph);
        int[]dis=new int[Graph.length];
        for(int i=0;i<dis.length;i++){
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(src, 0, 0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            if(curr.stop>k)break;
            for(int i=0;i<Graph[curr.node].size();i++){
                Edge e=Graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(curr.cost+wt<dis[v]){

                        dis[v]=curr.cost+wt;

                        // add node in pq with updated distance
                        q.add(new Pair(v,dis[v],curr.stop+1));

                    }
            }
            
        }
        if(dis[dest]==Integer.MAX_VALUE)return -1;
        return dis[dest];
    }
    public static void main(String[] args) {
        int n=4;
        int[][] flights={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(cheaptestFlight(n, flights, 0, 3, 1));

    }
}
