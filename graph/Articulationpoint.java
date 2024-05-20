import java.util.ArrayList;

public class Articulationpoint {
    static class  Edge {
        int src;
        int dest;
        
        public Edge(int s,int d){
            src=s;
            dest=d;
           
        }
    
    }
    static void createGraph(int v,ArrayList<Edge> Graph[]){
        for(int i=0;i<v;i++){
            Graph[i]=new ArrayList<>();
        }
        Graph [0] . add (new Edge(0,1)); 
        Graph [0] .add (new Edge(0,2));
        Graph [0] .add (new Edge(0,3) );
       
        Graph [1] . add (new Edge( 1,0));
        Graph [1]. add (new Edge( 1,2));

        Graph [2]. add (new Edge( 2,  0));
         Graph [2] .add (new Edge( 2,1));

        Graph [3] .add (new Edge( 3,0));
        Graph[3] .add (new Edge(3,4));
        Graph[3] .add (new Edge(3,5));

        Graph [4]. add (new Edge ( 4,  3));
        Graph [4]. add (new Edge ( 4,  5));
       
        Graph [5]. add (new Edge ( 5,  3));
        Graph [5]. add (new Edge ( 5,  4));
    }
    static Edge bridge;
    static void dfs(int curr,int par,boolean[]visited,ArrayList<Edge>[]Graph,int[]dt,int[]low,int time){
        visited[curr]=true;
        dt[curr]=low[curr]=++time;
        int child=0;
        for(int i=0;i<Graph[curr].size();i++){
            Edge e=Graph[curr].get(i);
            int neigh=e.dest;
            if(neigh==par)continue;
            else if(!visited[neigh]){
                dfs(neigh,curr, visited, Graph,dt,low,time);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(par!=-1&&dt[curr]<=low[neigh]){
                   System.out.println(curr);
                }
                child++;
            }
            else{
                low[curr]=Math.min(low[curr], dt[neigh]);
            }
        }
        if(par==-1 && child>1){
            System.out.println(curr);
        }
    }

    
    static  void trajanAlgop(ArrayList<Edge> Graph[],int v){
        boolean[]visited=new boolean[Graph.length];
        int[]dt=new int[v];
        int[]low=new int[v];int time=0;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(i, -1, visited, Graph, dt, low, time);
            }
        }

    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge>[]Graph=new ArrayList[v];
        createGraph(v, Graph);
        trajanAlgop(Graph, v);
    }
}
