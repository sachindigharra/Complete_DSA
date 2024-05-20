import java.util.*;
public class Adjmatrix {
    int[][] adj;
    Adjmatrix(int v){
        adj=new int[v][v];
    }
    public void insert(int s,int d){
        adj[s][d]=1;
        adj[d][s]=1;
    }
    public void creategraph(){
        insert(0, 1);
		insert(0, 2);
		insert(0, 3);
		insert(2, 1);
    }
    public void display(){
       for(int[]ele:adj){
            System.out.println(Arrays.toString(ele));
       }
    }
    public static void main(String[] args) {
        Adjmatrix g=new Adjmatrix(4);
        g.creategraph();
        g.display();
    }
}
