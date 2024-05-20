public class Wordsearch {
    public static boolean wordSeq(int i,int j,int idx,char[][]board,char[]ch,boolean[][]vis){
        if(idx==ch.length)return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j]!=ch[idx]|| vis[i][j]) return false;
        vis[i][j]=true;
        if(wordSeq(i+1, j,  idx+1, board, ch,vis)||wordSeq(i-1, j,  idx+1, board, ch,vis)
        ||wordSeq(i, j+1,idx+1, board, ch,vis)||wordSeq(i, j-1,idx+1, board, ch,vis))return true;
        vis[i][j]=false;
        return false;
                
    }

    public static boolean exist(char[][] board, String word) {
        char ch[]=word.toCharArray();
        boolean[][]vis=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==ch[0] && wordSeq(i, j,  0, board, ch,vis)){
    
                    return true;
                }
            }
       
        }
        return false;
    }
    public static void main(String[] args) {
        char[][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        System.out.println(exist(board, word));
        
    }

}
