import java.util.*;
public class Minmahatandis {
    // tabulation approach
    public int minimumDistance(int[][] points) {
        int n=points.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int[][]dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            dp[i][0]=Math.abs(0-points[i-1][0])+Math.abs(0-points[i-1][1]);
        }
        for(int i=1;i<=n;i++){
            dp[0][1]=Math.abs(0-points[i-1][0])+Math.abs(0-points[i-1][1]);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
               if(dp[i][j]!=-1)continue;
               if(i==j)dp[i][j]=0;
               
                    int dis=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                    dp[i][j]=dis;
                    dp[j][i]=dis;
                    
                    max=Math.max(max,dp[i][j]);
                    min=Math.min(min,dp[i][j]);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        
    }
}
