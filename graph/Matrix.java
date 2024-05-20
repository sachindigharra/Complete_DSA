import java.util.*;
import java.util.LinkedList;

public class Matrix {
   
    public static  int[][] updateMatrix(int[][] mat) {
    
                int m = mat.length, n = mat[0].length; 
                Queue<int[]> q = new LinkedList<>();
                for (int r = 0; r < m; ++r){
                    for (int c = 0; c < n; ++c){
                        if (mat[r][c] == 0) q.offer(new int[]{r, c});
                        else{
                            mat[r][c] = -1;
                        }
                    }
                } 
                int[] n4 = new int[]{0, 1, 0, -1, 0};
                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    int r = curr[0], c = curr[1];
                    for (int i = 0; i < 4; ++i) {
                        int nr = r + n4[i], nc = c + n4[i+1];
                        if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                        mat[nr][nc] = mat[r][c] + 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
                return mat;
        }
       
        // int row=mat.length;
        // int col=mat[0].length;
        // boolean [][]visit=new boolean[row][col];
        // int dist[][] = new int[row][col]; 
        // Queue<Pair>q=new LinkedList<>();
        // for(int i=0;i<row;i++){
        //     for(int j=0;j<col;j++){
        //         if(mat[i][j]==1){
        //             q.add(new Pair(i,j,0));
        //             visit[i][j] = true;
        //         }
        //     }
        // }
        // while(!q.isEmpty()){
        //     Pair curr=q.remove();
        //     int dx[] = {0, 0, 1, -1};
        //     int dy[] = {1, -1, 0, 0};
        //     dist[curr.x][curr.y]=curr.d;
        //     for(int i=0;i<4;i++){
        //         int x=curr.x+dx[i];
        //         int y=curr.y+dy[i];
        //         if(x < 0 || y < 0 || x >= row || y >= col|| visit[x][y]
        //         ) continue;
        //         q.add(new Pair(x, y, curr.d+1));
        //         visit[x][y]=true;
        //     }
        // }
        // return dist;
    
    public static void main(String[] args) {
        int mat[][]={{0,0,0},{0,1,0},{1,1,1}};
        int res[][]=updateMatrix(mat);
        for(int[] i:res){
            for(int j=0;j<i.length;j++){
                System.out.print(i[j]+" ");
            }
            System.out.println();
        }
    }
}
