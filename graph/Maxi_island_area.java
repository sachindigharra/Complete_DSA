public class Maxi_island_area {
    static int ROW, COL, count;
    static boolean isSafe(int[][] M, int row, int col,boolean[][] visited){
        return ((row >= 0) && (row < ROW) && (col >= 0)&& (col < COL)&& (M[row][col] == 1 && !visited[row][col]));
    }
    static void DFS(int[][] M, int row, int col,boolean[][] visited){
        int[] rowNbr = {0, 0, -1, 1 };
        int[] colNbr = { 1,-1, 0,0};
        visited[row][col] = true;
        for (int k = 0; k < 4; k++) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k],visited)) {
                count++;
                DFS(M, row + rowNbr[k], col + colNbr[k],visited);
            }
        }
    }
    static int largestRegion(int[][] M){
        ROW=M.length;
        COL=M[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        int result = 0;for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                count = 1;
                DFS(M, i, j, visited);
                result = Math.max(result, count);
            }
        }
    }return result;}
    // static int row,col,count;
    // public static int maxArea(int[][]grid){
    //     int res=0;
    //     row=grid.length;
    //     col=grid[0].length;
    //     boolean[][]visit=new boolean[row][col];
    //     for(int i=0;i<row;i++){
    //         for(int j=0;j<col;j++){
    //             if(grid[i][j]==1&& !visit[i][j]){
    //                 count=1;
    //                 dfsUtil(grid, i, j, visit);
    //                 Math.max(res,count);
    //             }
    //         }
    //     }
    //     return res;
    // }
    // public static boolean is_Safe(int[][]grid,boolean[][]visit,int x,int y){
    //     return ((x >= 0) && (x < row) && (y >= 0)&& (y < col)&& (grid[x][y] == 1 && !visit[x][y]));
    // }
    // public static void dfsUtil(int[][]grid,int x,int y,boolean[][]visit){
    //     int[]dx={0,0,-1,1};
    //     int[]dy={1,-1,0,0};
    //     visit[x][y]=true;
    //     for(int j=0;j<4;j++){
    //         if(is_Safe(grid, visit, x+dx[j], y+dy[j])){
    //             count++;
    //             dfsUtil(grid, x+dx[x], y+dy[j], visit);
    //         }
    //     }
    // }
    public static void main(String[] args) {
        int[][]grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(largestRegion(grid));
    }
    
}
