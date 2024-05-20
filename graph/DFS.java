import java.util.ArrayList;

public class DFS {
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
    
    static void depthFirstSearch(ArrayList<Edge> Graph[],int curr,boolean []visited){
        if(Graph.length<2) return;
        System.out.print(curr+"  ");
        visited[curr]=true;
        for(int i=0;i<Graph[curr].size();i++){
            Edge e=Graph[curr].get(i);
            if(!visited[e.dest]){
                depthFirstSearch(Graph, e.dest,visited);
            }
        }
    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<Edge>[]Graph=new ArrayList[v];
        createGraph(v, Graph);
        boolean[] visited=new boolean[Graph.length];
        depthFirstSearch(Graph, 0, visited);

    }
    
}
