public class Surroundedbyx {
    public static char[][]replace_O_by_X(char[][]mat){
        int row=mat.length;
        int col=mat[0].length;
        boolean visit[][]=new boolean[row][col];
        int[]dx={-1,0,1,0};
        int[]dy={0,1,0,-1};
        //Traver first and last row to Track O at boundary
        for(int j=0;j<col;j++){
            //first row
            if(!visit[0][j] && mat[0][j]=='O'){
                dfsUntil(mat, visit, 0, j,dx,dy);
            }
            //last Row
            if(!visit[row-1][j] && mat[row-1][j]=='O'){
                dfsUntil(mat, visit, row-1, j,dx,dy);
            }
        }
        //traverse first and Last Column
        for(int i=0;i<row;i++){
            //first row
            if(!visit[i][0] && mat[i][0]=='O'){
                dfsUntil(mat, visit, i, 0,dx,dy);
            }
            //last Row
            if(!visit[i][col-1] && mat[i][col-1]=='O'){
                dfsUntil(mat, visit,i,col-1,dx,dy);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visit[i][j]){
                    mat[i][j]='X';
                }
            }
        }
        return mat;
    }
    public static void dfsUntil(char[][]mat ,boolean[][]visit,int x,int y,int[]dx,int[]dy){
        visit[x][y]=true;
        int row=mat.length;
        int col=mat[0].length;
        for(int j=0;j<4;j++){
            int nr=x+dx[j];
            int nc=y+dy[j];
            if(nr < 0 || nc < 0 || nr >= row || nc >= col || mat[nr][nc] != 'O' || 
            visit[nr][nc] ) continue;
            else{
                dfsUntil(mat, visit, nr, nc, dx, dy);
            }
        }
    }
    public static void main(String[] args) {
        char mat[][] = {
            {'X', 'X', 'X', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'O', 'O', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'X', 'O', 'O'}};
           mat= replace_O_by_X(mat);
           for(char[] c:mat){
                for(char ch:c){
                    System.out.print(ch+" ");
                }
                System.out.println();
           }
    }
}
