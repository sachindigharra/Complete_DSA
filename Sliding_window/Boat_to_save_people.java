import java.util.Arrays;

public class Boat_to_save_people {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res=0;
        int l=0;
        int r=people.length-1;
        while(l<=r){
            if(people[r]+people[l]<=limit){
                res++;
                l++;
                r--;
            }
            else if(people[r]<=limit){
                r--;
                res++;
            }
        }
        return res;
        
    }
    public static void main(String[] args) {
        int[]n={1,2,3,8,4};
        System.out.println(numRescueBoats(n, 9));
    }
}
