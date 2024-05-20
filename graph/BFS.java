import java.util.*;
import java.util.LinkedList;
public class BFS {
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
    static void createGraph(int v,ArrayList<Edge> Graph[]){
        for(int i=0;i<v;i++){
            Graph[i]=new ArrayList<>();
        }
        // vertex 0
        Graph[0].add(new Edge(0, 1, 1));
        Graph[0].add(new Edge(0, 2, 1));
        // vertex 1
        Graph[1].add(new Edge(1, 3, 1));
        Graph[1].add(new Edge(1, 0, 1));
        //Vertex 2
        Graph[2].add(new Edge(2, 4, 1));
        Graph[2].add(new Edge(2, 0, 1));
        // vertex 3
        Graph[3].add(new Edge(3, 1, 1));
        Graph[3].add(new Edge(3, 4, 1));
        Graph[3].add(new Edge(3, 5, 1));

        //vertex 4
        Graph[4].add(new Edge(4, 2, 1));
        Graph[4].add(new Edge(4, 3, 1));
        Graph[4].add(new Edge(4, 5, 1));
        
        //vertex 5
        Graph[5].add(new Edge(5, 3, 1));
        Graph[5].add(new Edge(5, 4, 1));
        Graph[5].add(new Edge(5, 6, 1));
        //vertex 6
        Graph[6].add(new Edge(6, 5, 1));
    }
    
    static void breadthFirstSearch(ArrayList<Edge> Graph[]){
        Queue<Integer> q=new LinkedList<>();
        if(Graph.length<1)return;
        //track node of graph is traverse or not
        boolean visited[]=new boolean[Graph.length];
        q.offer(0);
        while (!q.isEmpty()) {
            int cur=q.remove();
            if(!visited[cur]){
                System.out.println(cur);
                visited[cur]=true;
                for(int i=0;i<Graph[cur].size();i++){
                    Edge e=Graph[cur].get(i);
                    q.add(e.dest);
                }
            }
            
        }
        
       
    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<Edge>[]Graph=new ArrayList[v];
        createGraph(v, Graph);
        breadthFirstSearch(Graph);
    }
}
