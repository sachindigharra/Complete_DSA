import java.util.*;
import java.util.LinkedList;
public class Rootten_orange {
    static int roottingOranges(int[][] grid){
        int total_org=0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
                if(grid[i][j]!=0)  total_org++;
               
            }
        }
        if(total_org==0 || q.size()==total_org)return 0;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        int cnt=0;
        int min_time=0;
        while(!q.isEmpty()){
            int size=q.size();
            cnt+=size;
            for(int i=0;i<size;i++){
                int[] point = q.poll();
                for(int j=0;j<4;j++){
                    int x=point[0]+dx[j];
                    int y=point[1]+dy[j];
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || 
                    grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x , y});
                }
            }
            if(q.size()!=0){
                min_time++;
            }
        }
       return total_org==cnt?min_time:-1;
       
    }
    public static void main(String[] args) {
        int[][]grid={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(roottingOranges(grid));
    }
}
