import java.util.*;


public class Connectedgraph {
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
        //Vertex 7
        Graph[7].add(new Edge(7, 8, 1));
        //vertex 8
        Graph[7].add(new Edge(8, 7, 1));
    }
    static void traverseGraphElement(ArrayList<Edge>[]Graph){
        boolean[]visited=new boolean[Graph.length];
        for(int i=0;i<Graph.length;i++){
            if(!visited[i]){
                dfsUtil(Graph, visited, i);
            }
        }

    }
    static void dfsUtil(ArrayList<Edge>[]Graph,boolean[]visited,int src){
        System.out.print(src+" ");
        visited[src]=true;
        for(int i=0;i<Graph[src].size();i++){
            Edge e=Graph[src].get(i);
            if(!visited[e.dest]){
                dfsUtil(Graph, visited, e.dest);
            }
        }

    }
    public static void main(String[] args) {
        int v=9;
        ArrayList<Edge>[]Graph=new ArrayList[v];
       
        createGraph(v, Graph);
        traverseGraphElement(Graph);
       
    }
}
