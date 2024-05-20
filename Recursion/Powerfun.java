public class Powerfun {
    static int power(int a , int n){
        if(n==1)return a;
        return a*power(a, n-1);
    }
    static double optimizedPower(double a, int n){
        if(n==1)return a;
        if(n<0){
            n=n*-1;
            double hlafpower=optimizedPower(a, n/2);
             double hlfsq=hlafpower*hlafpower;
            // n is odd
            if(n%2!=0){
            hlfsq=a*hlfsq;
            }
        return 1/hlfsq;
        }
        double hlafpower=optimizedPower(a, n/2);
        double hlfsq=hlafpower*hlafpower;
        // n is odd
        if(n%2!=0){
            hlfsq=a*hlfsq;
        }
        return hlfsq;

    }
    public static void main(String[] args) {
        System.out.println(optimizedPower(2, -5));
    }
}
