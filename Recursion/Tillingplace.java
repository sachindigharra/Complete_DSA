public class Tillingplace {
    public static int tillingWays(int n){
        if(n==1 || n==0) return 1;
        //place tile in Horizantal way
        int plh=tillingWays(n-2);
        //place tile in Vertical way
        int ptv = tillingWays(n-1);
        return plh+ptv;
    }
    public static void main(String[] args) {
        System.out.println(tillingWays(4));
    }
}
