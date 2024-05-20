public class Knapsack {
    public static int recu_App(int[]val,int []wt,int W,int n){
        if(W==0 || n==0)return 0;
        if(wt[n-1]<=W){// valid 
            //include item
            int ans1=val[n-1]+recu_App(val, wt, W-wt[n-1], n-1);
            //Exclude
            int ans2=recu_App(val, wt, W, n-1);
            return Math.max(ans1,ans2);

        }//Not valid
        
        return recu_App(val, wt, W, n-1);
        
    }
    // Memoization Approach
    public static int memoApp(int[]val,int []wt,int W,int n,int[][]dp){
        if(n==0|| W==0)return 0;
        if(dp[n][W]!=-1)return dp[n][W];
        if(wt[n-1]<=W){// valid 
            //include item
            int ans1=val[n-1]+memoApp(val, wt, W-wt[n-1], n-1,dp);
            //Exclude
            int ans2=memoApp(val, wt, W, n-1,dp);
            dp[n][W]= Math.max(ans1,ans2);
            return dp[n][W];
        }//Not valid
        dp[n][W]=memoApp(val, wt, W, n-1,dp);
        return dp[n][W] ;
    }
    public static int knapsackTabulation(int[]val,int[]wt,int W){
        int n=val.length;

        int [][]dp=new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=W;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                int v=val[i-1]; //ith item Value
                int w=wt[i-1]; //ith item Weight 
                if(w<=j){// Valid
                    //Include
                    int incprofit=v+dp[i-1][j-w];
                    //Exclude
                    int excprofit=dp[i-1][j];
                    dp[i][j]=Math.max(incprofit,excprofit);
                }
                else{// invalid
                    dp[i][j]=dp[i-1][j]; 

                }

            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int[]val={15,14,10,45,30};
        int[]wt={2,5,1,3,4};
        int W=7;
        int n=val.length;
        // System.out.println(recu_App(val, wt, W, n));
        // int dp[][]=new int[n+1][W+1];
        // for(int i=0;i<=n;i++){
        //         for(int j=0;j<=W;j++){
        //             dp[i][j]=-1;
        //         }
        // }
        //System.out.println(memoApp(val, wt, W, n, dp));
        System.out.println(knapsackTabulation(val, wt, W));
    }
}
