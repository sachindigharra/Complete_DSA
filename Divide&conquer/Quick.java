import java.util.Arrays;

public class Quick {
    public static void quickSort(int[] arr ,int si,int ei ){
        if(si>=ei)return;
        int pidx=partition(arr, si, ei);
       // System.out.println(pidx);
       quickSort(arr, si, pidx-1);
       quickSort(arr, pidx+1, ei);
        
    }
    public static int partition(int[] arr ,int si,int ei){
        int pivot=arr[ei];
        int i=si-1;
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        //System.out.print(Arrays.toString(arr));

        return i;
    }
    public static void main(String[] args) {
        int[]x={1,2,3,4,5,6};
        quickSort(x, 0, x.length-1);
        System.out.println(Arrays.toString(x));
    }
}
