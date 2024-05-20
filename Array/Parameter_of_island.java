import java.util.*;
public class Parameter_of_island {
    public  static int islandPerimeter(int[][] grid) {
        Queue<int[]>q=new LinkedList();
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1)q.add(new int[]{i,j});
            }
        }
        if(q.isEmpty())return 0;
        if(q.size()==0)return 4;
        int para=0;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        while(!q.isEmpty()){
            int []curr=q.remove();
            for(int i=0;i<4;i++){
                int x=curr[0]+dx[i];
                int y=curr[1]+dy[i];
                //Land Peice at Boundary so we include in para
                if(x < 0 || y < 0 || x >= row || y >= col){
                    para++;
                    continue;
                }

                if(grid[x][y]==1)continue;
                para++;
                
            }
        }
        return para;

    }
    public static void main(String[] args) {
        int[][]grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}
