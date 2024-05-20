public class friendspair {
    public static int friendsPairWays(int n){
        if(n==1  || n == 2)return n;
        int ways=(friendsPairWays(n-1)+(n-1)*friendsPairWays(n-2));
        return ways; 
    }
    public static void main(String[] args) {
        System.out.println(friendsPairWays(10));
    }
}
