import java.util.ArrayList;
import java.util.List;

public class Allpath {
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
        Graph[0].add(new Edge(0, 3));
        Graph[2].add (new Edge( 2,  3));
        Graph [3] .add (new Edge( 3,  1));
        Graph [4]. add (new Edge( 4,0));
        Graph [4]. add (new Edge( 4,  1));
        Graph [5] .add (new Edge( 5,  0)); 
        Graph [5]. add (new Edge( 5,  2));
    }
    static void all_Possible_path(ArrayList<Edge>[]Graph,int src,int dest,String path,List<String>list){{
        path=path+src;
        if(src==dest){
            list.add(path);
            return;
        }
        for(int i=0;i<Graph[src].size();i++){
            path+="->";
            Edge e=Graph[src].get(i);
            all_Possible_path(Graph, e.dest, dest, path, list);
        }
    }

    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge>[]Graph=new ArrayList[v];
        createGraph(v, Graph);
        List<String>ls=new ArrayList<>();
        all_Possible_path(Graph, 5, 1, "", ls);
        for(String i:ls){
            System.out.println(i);
        }
    }
}
