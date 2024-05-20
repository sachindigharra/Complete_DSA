import java.util.ArrayList;

public class Cycledirectedg {
    static class  Edge {
        int s;
        int d;
        
        public Edge(int s,int d){
            this.s=s;
            this.d=d;
           
        }
    
    }
    static void createGraph(int v, ArrayList<Edge>[]Graph){
        for(int i=0;i<v;i++){
            Graph[i]=new ArrayList<>();
        }
        Graph [0].add (new Edge(0, 2));
        Graph [1]. add (new Edge( 1,  0));
        Graph [2]. add (new Edge( 2,  3));
        Graph [3].  add (new Edge(3,0));
    }
    static boolean cyclicDectection(ArrayList<Edge>[]Graph){
        // visited track vertex is visit or not
        boolean[]visit=new boolean[Graph.length];
        //callStack track vertex is call by dfs fun 
        boolean[] callStack=new boolean[Graph.length];
        for(int i=0;i<Graph.length;i++){
            if(!visit[i]){
                if(cyclicDectectionUitl(i, visit, callStack,Graph)){
                    return true;
                }
            }
        }
        return false;
        

    }
    static boolean cyclicDectectionUitl(int curr,boolean[]visit,boolean[]callStack,ArrayList<Edge>[]Graph){
        visit[curr]=true;
        callStack[curr]=true;
        for(int i=0;i<Graph[curr].size();i++){
            Edge e=Graph[curr].get(i);
            if(callStack[e.d]){
                return true;
            }
            if(!visit[e.d] && cyclicDectectionUitl(e.d,visit,callStack,Graph)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge>[]Graph=new ArrayList[v];
        createGraph(v, Graph);
        System.out.println(cyclicDectection(Graph));
    }
}
