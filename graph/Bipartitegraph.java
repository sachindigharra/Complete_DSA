import java.util.*;
import java.util.LinkedList;
public class Bipartitegraph {
    static class Edge {
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

        //vertex 0
        Graph [0].add (new Edge( 0,  1)); 
        Graph [0].add (new Edge( 0,  2));
        //vertex 1
        Graph [1].add (new Edge( 1,  0)); 
        Graph [1].add (new Edge( 1, 3));
        //vertex 2
        Graph [2]. add (new Edge( 2,  0));
        Graph [2]. add (new Edge( 2,  4));
        //vertex 3
        Graph [3].add (new Edge( 3,  1));
        Graph [3] .add (new Edge( 3,  4));
        //vertex 4
        Graph [4].add (new Edge( 4,  2)); 
        Graph [4].add (new Edge( 4,  3));
    }
    // We use coloring Algorithm select two differnet color so we don't need more space 
    // easliy Understandable
    static boolean isBipartiteGraph(ArrayList<Edge>[]Graph){
        int []col=new int[Graph.length];
        for(int i=0;i<Graph.length;i++){
            col[i]=-1; //no color
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<Graph.length;i++){

            if(col[i]<0){

                q.add(i);

                col[i]=0;//yellow

                while (!q.isEmpty()) {

                    int temp=q.remove();

                   for(int j=0;j<Graph[temp].size();j++){

                        Edge e=Graph[temp].get(j);

                        //case -1 vertex is not colored
                       if(col[e.dest]==-1){

                        //opposite color assign
                            int nextcol= col[temp] ==0 ? 1 : 0;

                            col[e.dest]=nextcol;
                            q.add(e.dest);

                       }
                        else if(col[temp]==col[e.dest]){

                            return  false;
                        }

                   }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>[]Graph=new ArrayList[v];
       
createGraph(v, Graph);
        System.out.println(isBipartiteGraph(Graph));

        
    }
}
