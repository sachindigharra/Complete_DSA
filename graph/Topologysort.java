import java.util.ArrayList;
import java.util.Stack;

public class Topologysort {
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
        Graph[2].add (new Edge( 2,  3));
        Graph [3] .add (new Edge( 3,  1));
        Graph [4]. add (new Edge( 4,0));
        Graph [4]. add (new Edge( 4,  1));
        Graph [5] .add (new Edge( 5,  0)); 
        Graph [5]. add (new Edge( 5,  2));
    }
    static void topologySorting(ArrayList<Edge>[]Graph){
        boolean[]visit=new boolean[Graph.length];
        Stack<Integer> seq=new Stack<>(); 
        for(int i=0;i<Graph.length;i++){
            if(!visit[i]){
                dfsUtil(Graph, i, visit, seq);
            }
        }
        while (!seq.isEmpty()) {
            System.out.print(seq.pop()+" ");
            
        }
        System.out.println();
    }
    static void dfsUtil(ArrayList<Edge>[]Graph,int curr,boolean[]visit,Stack<Integer> seq){
        visit[curr]=true;
        for(int i=0;i<Graph[curr].size();i++){
            Edge e=Graph[curr].get(i);
            if(!visit[e.dest]){
                dfsUtil(Graph, e.dest, visit, seq);
            }
           
        }
        seq.add(curr); 
       
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge>[]Graph=new ArrayList[v];
       
        createGraph(v, Graph);
        topologySorting(Graph);
    }
}
