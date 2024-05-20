import java.util.*;

public class Nqueens {
    public static boolean isSafe(char[][]board,int row,int col){
        // verticaly up direction
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q')return false;
        }
        //diagonal left up direction
        for(int i=row-1, j=col-1;i>=0 &&j>=0; i--,j--){
            if(board[i][j]=='Q')return false;
        }
        // diagonal right up direction
        for(int i=row-1, j=col+1;i>=0 &&j<board.length; i--,j++){
            if(board[i][j]=='Q')return false;
        }
        return true;
    }
    public static void solveNQueens(char[][]grid,int row) {
        if(row==grid.length){
            print(grid);
            return;
        }
        for(int j=0;j<grid.length;j++){
           if(isSafe(grid, row, j)){
                grid[row][j]='Q';
                solveNQueens(grid, row+1);// funcation call
                grid[row][j]='x';// back track call
           }
        }
        
    }
    public static void print(char[][] board){
        for(int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[][]board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        solveNQueens(board, 0);
        
    }
}
