import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Khantogo {
   
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
        int []indeg=new int[Graph.length];
        calIndegree(Graph, indeg);
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<Graph.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while (!q.isEmpty()) {
            count++;
            int curr=q.remove();
            System.out.print(curr+" ");
            for(int i=0;i<Graph[curr].size();i++){
                Edge e=Graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println(count);

    }
    static void calIndegree(ArrayList<Edge>[]Graph,int[]indeg){
        for(int i=0;i<Graph.length;i++){
            int v=i;
            for(int j=0;j<Graph[v].size();j++){
                Edge e=Graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge>[]Graph=new ArrayList[v];
       
        createGraph(v, Graph);
        topologySorting(Graph);
    }
    
}
