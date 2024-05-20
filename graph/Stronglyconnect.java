import java.util.*;
public class Stronglyconnect {
    static class  Edge {
        int src;
        int dest;
        
        public Edge(int s,int d){
            src=s;
            dest=d;
        }
    
    }
    static void createGraph(int v,ArrayList<Edge>[]Graph){
        for(int i=0;i<v;i++){
            Graph[i]=new ArrayList<>();
        }
        Graph [0]. add (new Edge( 0,2) );
        Graph [0] .add (new Edge( 0, 3));
        Graph [1]. add (new Edge( 1,  0));
        Graph [2]. add (new Edge( 2,  1));
        Graph [3]. add (new Edge(3,4));
    }
    public static void topoSort(ArrayList<Edge>[]Graph,int curr,boolean[]visit,Stack<Integer>s){
        visit[curr]=true;
        for(int i=0;i<Graph[curr].size();i++){
            Edge e=Graph[curr].get(i);
            if(!visit[e.dest]){
                topoSort(Graph, e.dest, visit, s);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge>[]transpose,int curr,boolean[]visit){
        visit[curr]=true;
        System.out.print(curr);
        for(int i=0;i<transpose[curr].size();i++){
            Edge e=transpose[curr].get(i);
            if(!visit[e.dest]){
                dfs(transpose, e.dest, visit);
            }
        }
    }
    public static void koSaraju(int v,ArrayList<Edge>[]Graph){
        Stack<Integer>s=new Stack<>();
        boolean[]visit=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visit[i]){
                topoSort(Graph, i, visit, s);
            }
        }
        // transpose Graph
        ArrayList<Edge>[]transpose=new ArrayList[v];
        for(int i=0;i<v;i++){
            visit[i]=false;
            transpose[i]=new ArrayList<>();
        }
        for(int i=0;i<v;i++){
            for(int j=0;i<Graph[i].size();j++){
                Edge e=Graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        while(!s.empty()){
            int curr=s.pop();
            if(!visit[curr]){
                System.out.print("scc->");
                dfs(transpose, curr, visit);
               System.out.println();
            }
        }

    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>[]Graph=new ArrayList[v];
       
        createGraph(v, Graph);
        koSaraju(v, Graph);
    }
    
}
