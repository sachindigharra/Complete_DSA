import java.util.*;
public class Cycleundirectgraph {
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
    
    //detect cycle
    static boolean isCyclicGraph(ArrayList<Edge>[]Graph){
        boolean[]visit=new boolean[Graph.length];
        for(int i=0;i<visit.length;i++){
            if(!visit[i]){
                if(isCyclicGraphUitl(Graph, visit, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean isCyclicGraphUitl(ArrayList<Edge>[]Graph,boolean[]visit,int curr,int par ){
        visit[curr]=true;
        for(int i=0;i<Graph[curr].size();i++){
            Edge e=Graph[curr].get(i);
            //case 1 vertex is visited not through parent vertex
            if(visit[e.dest]&& par!=e.dest){
                return true;
            }
            // case-2 vertex is not then visited and then check is parent is same or not by call back function
            else if(!visit[e.dest]&& isCyclicGraphUitl(Graph, visit,e.dest,curr)){
                return true;
            }
        
        }
        return false;
    }
    
    public static void main(String[] args) {
        int v=9;
        ArrayList<Edge>[]Graph=new ArrayList[v];
       
        createGraph(v, Graph);
        System.out.println(isCyclicGraph(Graph));
    }
}