public class Disjointset {
    static int n;
    static int[]par;
    static int[]rank;
    static void creteDisJointds(int s){
        n=s;
        par =new int[n];
        rank =new int[n];
    }
    static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    static int find(int a){
        if(n<a)return -1;
        if(par[a]==a){
            return a;
        }
        return par[a]=find(par[a]);
    }
    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){
            par[parA]=parB;
            rank[parB]++;
        }
        else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }
        else{
            par[parB]=parA;
        }
        
    }
    public static void main(String[] args) {
        creteDisJointds(7);
        init();
       union(1, 3);
       System.out.println(find(1));
    }
    
}
