import java.util.ArrayList;

public class Bellford_algo {
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
        Graph[0] .add (new Edge( 0,  1,  2)); 
        Graph[0]. add (new Edge( 0,  2,  4));

        Graph[1]. add (new Edge( 1,  2, -4));

        Graph[2]. add (new Edge(2,3,2));

        Graph[3]. add (new Edge( 3,  4,  4));

        Graph[4]. add (new Edge(4,1,-1));
      
    }
    public static void createGraph2(ArrayList<Edge>adj){
        adj .add (new Edge( 0,  1,  2)); 
        adj. add (new Edge( 0,  2,  4));

        adj. add (new Edge( 1,  2, -4));

        adj. add (new Edge(2,3,2));

        adj. add (new Edge( 3,  4,  4));
        adj. add (new Edge(4,1,-1));
    }
    public static void  bellFordAdj(ArrayList<Edge>Graph,int src,int v){
        int[]dist=new int[v];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        
        for(int i=0;i<v-1;i++){
                for(int k=0;k<Graph.size();k++){
                    Edge e= Graph.get(k);
                    // u,v and wt
                    int x=e.src;
                    int y=e.dest;
                    int w=e.wt;
                    //relaxation
                    if(dist[x]!=Integer.MAX_VALUE && dist[x]+w<dist[y]){
                        dist[y]=dist[x]+w;
                    }

                }
        }
        for(int i:dist){
            System.out.print(i+" ");
        }
    }
    // using Graph
    public static void  bellFord(ArrayList<Edge>[]Graph,int src){
        int[]dist=new int[Graph.length];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int v=Graph.length;
        for(int i=0;i<v-1;i++){
            for(int j=0;j<Graph.length;i++){
                for(int k=0;k<Graph[j].size();k++){
                    Edge e= Graph[j].get(k);
                    // u,v and wt
                    int x=e.src;
                    int y=e.dest;
                    int w=e.wt;
                    //relaxation
                    if(dist[x]!=Integer.MAX_VALUE && dist[x]+w<dist[y]){
                        dist[y]=dist[x]+w;
                    }

                }
            }
        }
    }
    public static void main(String[] args) {
        int v=5;
        // ArrayList<Edge>[]Graph=new ArrayList[v];
       
        // createGraph(v, Graph);

        ArrayList<Edge> adj=new ArrayList<>();
        createGraph2(adj);
        bellFordAdj(adj, 0, v);
    }
}
