import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Aleindict {
   public static List<Integer> topoSort(int V, ArrayList<Integer>[] adj) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj[node]) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        return topo;
    }
    public static String orderBydict(int n,int k,String[]dict){
        if(n==0)return "";
        if(n==1)return  dict[0];
        ArrayList<Integer>[]Graph=new ArrayList[k];
        for(int i=0;i<k;i++){
            Graph[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            String s1=dict[i];
            String s2=dict[i+1];
            int len=Math.min(s1.length(),s2.length());
            for(int j=0;j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    Graph[s1.charAt(j)-'a'].add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(k, Graph);
        String ans = "";
        for (int it : topo) {
            ans = ans + (char)(it + (int)('a'));
        }

        return ans;
        
    }
            
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(orderBydict(N, K, dict));
    }
}
