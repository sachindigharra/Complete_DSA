public class Fibonaci {
    public static int fibonaciSeries(int n){
        if(n<=2)return 1;
        return fibonaciSeries(n-1)+fibonaciSeries(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fibonaciSeries(13));
        int x=1;
        String s=x+"";
        System.out.println(s);
    }
    
}
