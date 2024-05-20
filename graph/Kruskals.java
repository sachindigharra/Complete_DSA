import java.util.*;
public class Kruskals{
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int weight;
        public Edge(int src,int dest,int weight){
                this.src=src;
                this.dest=dest;
                this.weight=weight;
        }
        @Override
        public int compareTo(Edge e) {
           
            return this.weight-e.weight;
        }
    }
    static void createGraph(ArrayList<Edge>graph){
        graph. add (new Edge(0,1,10));
        graph. add (new Edge(0,2,15));
        graph. add (new Edge(0,3,30));
        graph. add (new Edge( 1,3,40)) ;
       graph. add (new Edge( 2,3,50));
    }
    static int n;
    static int[]par;
    static int[]rank;
    static void creteDisJointds(int s){
        n=s;
        par =new int[n];
        rank =new int[n];
    }
    static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    static int find(int a){
        if(n<a)return -1;
        if(par[a]==a){
            return a;
        }
        return par[a]=find(par[a]);
    }
    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){
            par[parA]=parB;
            rank[parB]++;
        }
        else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }
        else{
            par[parB]=parA;
        }
        
    }
    public static void kruskalMst(ArrayList<Edge>graph,int v){
        int finalcost=0;
        int count=0;
        for(int i=0;count<v-1;i++){
            Edge e=graph.get(i);
            if(par[e.src]!=par[e.dest]){
                union(e.src, e.dest);
                finalcost+=e.weight;
                count++;
            }
        }
        System.out.println(finalcost);
    }
    public static void main(String[] args) {
        ArrayList<Edge>graph=new ArrayList<>();
      creteDisJointds(4);
        init();
        createGraph(graph);
        kruskalMst(graph, 4);
    }
}