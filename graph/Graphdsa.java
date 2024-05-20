import java.util.*;
import java.util.LinkedList;

public class Graphdsa {
      static class  Edge {
        int src;
        int d;
        int w;
        public Edge(int s,int d,int w){
            src=s;
            this.d=d;
            this.w=w;
        }
    
    }
    ArrayList<Edge>[] adj;
    
    @SuppressWarnings("unchecked")
    public Graphdsa(int v){
        adj=  new ArrayList[v];
       
    }
    // public void insert(int st,int d,int w){
    //     adj[0].add(new Edge(0, 1,1 ));
    //     adj[0].add(new Edge(0, 2,1 ));

    //     adj[1].add(new Edge(1, 0,1 ));
    //     adj[1].add(new Edge(1, 3,1 ));

    //     adj[2].add(new Edge(2, 0,1 ));
    //     adj[2].add(new Edge(2, 4,1 ));

    //     adj[3].add(new Edge(3, 1,1 ));
    //     adj[3].add(new Edge(3, 4,1 ));
    //     adj[3].add(new Edge(0, 5,1 ));

    //     adj[4].add(new Edge(4, 2,1 ));
    //     adj[4].add(new Edge(4, 3,1 ));
    //     adj[4].add(new Edge(4, 5,1 ));
        
    //     adj[5].add(new Edge(5, 3,1 ));
    //     adj[5].add(new Edge(5, 4,1 ));
    //     adj[5].add(new Edge(5, 6,1 ));
    //     adj[5].add(new Edge(6, 5,1 ));

    //     adj[6].add(new Edge(6, 5,1 ));
    // }
    public void creategraph(){
        for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<Edge>();
        }
        adj[0].add(new Edge(0, 1,1 ));
        adj[0].add(new Edge(0, 2,1 ));

        adj[1].add(new Edge(1, 0,1 ));
        adj[1].add(new Edge(1, 3,1 ));

        adj[2].add(new Edge(2, 0,1 ));
        adj[2].add(new Edge(2, 4,1 ));

        adj[3].add(new Edge(3, 1,1 ));
        adj[3].add(new Edge(3, 4,1 ));
        adj[3].add(new Edge(0, 5,1 ));

        adj[4].add(new Edge(4, 2,1 ));
        adj[4].add(new Edge(4, 3,1 ));
        adj[4].add(new Edge(4, 5,1 ));
        
        adj[5].add(new Edge(5, 3,1 ));
        adj[5].add(new Edge(5, 4,1 ));
        adj[5].add(new Edge(5, 6,1 ));
        adj[5].add(new Edge(6, 5,1 ));

        adj[6].add(new Edge(6, 5,1 ));
    }
    public void display(){
        for(ArrayList<Edge> ele:adj){
            System.out.println(ele);
        }
    }
    public void bfs(){
        Queue<Integer>q=new LinkedList<>();
        boolean[]visited=new boolean[adj.length];
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!visited[curr]){
                // visit the edge
                System.out.println(curr+" ");
                for (Edge e :adj[curr]) { 					
					  q.offer(e.d);
				}
            }
        }
    }
    public void dfs(){
        boolean[]visited=new boolean[adj.length];
        Stack<Integer>q=new Stack<>();
        q.push(0);
        while(!q.isEmpty()){
            int temp=q.pop();
            if(!visited[temp]){
                visited[temp]=true;
                System.out.println(temp+"");
                for(Edge e:adj[temp]){
                    if(!visited[e.d]){
                        q.push(e.d);
                    }
                }
            }
        }
        
    }static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.cost-p2.cost;
           
        }
        
        
    }
    public int prims(){
        boolean visit[]=new boolean[adj.length];
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        int finalcost=0;
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!visit[curr.v]){
                visit[curr.v]=true;
                finalcost+=curr.cost;
            }
            for(int i=0;i<adj[curr.v].size();i++){
                Edge e=adj[curr.v].get(i);
                pq.add(new Pair(e.d,e.w));
            }
        }
        return finalcost;
    }
    public  boolean isCyclepresent(ArrayList<Edge>[]adj){
        boolean[]visit=new boolean[adj.length];
        for(int i=0;i<visit.length;i++){
            if(!visit[i])
                if(detectcycleutil(adj, visit, i, -1))return true;
        }
        return false;
    }
    public boolean detectcycleutil(ArrayList<Edge>[]adj,boolean visit[],int curr,int par){
        visit[curr]=true;
        for(int i=0;i<adj[curr].size();i++){
            Edge e=adj[curr].get(i);
            if(!visit[e.d]){
                if(detectcycleutil(adj, visit, e.d, curr))
                return true;
            }
            else if(visit[e.d]&&par!=e.d)return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Graphdsa g=new Graphdsa(7);
        g.creategraph();
        g.display();
        g.bfs();
        System.out.println(g.prims());
    }

}
