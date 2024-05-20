public class Fastexpo {
    public static double getAnswer(double a,int  n){
        double ans=1;
        if(n<0){
            n=n*-1;
                while(n>0){
                    if((n&1)!=0){
                    ans=ans*a;
                
                    }
                    a=a*a;
                    n=n>>1;
                }
            return 1/ans;
        }
        while(n>0){
            if((n&1)!=0){
                ans=ans*a;
                
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(getAnswer(2, -5));
    }
    
}
