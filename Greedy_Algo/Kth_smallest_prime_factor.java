import java.util.*;
public class Kth_smallest_prime_factor {

    
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;
        ArrayList<float[]>ls=new  ArrayList<float[]>();
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                float[] temp=new float[3];
                temp[0]=((float) arr[j])/arr[i];
                temp[1]=(float)j;
                temp[2]=(float)i;
                ls.add(temp);
    
            }
        }
        Collections.sort(ls,(x,y)->((int)y[0]-(int)x[0]));
        for(int i=0;i<ls.size();i++){
            System.out.println(Arrays.toString(ls.get(i)));
        }
        int[]res=new int[2];
        return res;
    }
    public static void main(String[] args) {
        int[]arr={1,2,3,5};
        int k=4;
        kthSmallestPrimeFraction(arr, k);
    }
   
}
