import java.util.Arrays;

public class Sortmerge {
    public static void SortArr(int arr[],int si,int ei){
        // Base case
        if(si>=ei)return;
        int mid=si+(ei-si)/2;
        SortArr(arr, si, mid);
        SortArr(arr, mid+1, ei);
        Merge(arr, si, mid, ei);
    }
    public static void Merge(int arr[],int si,int mid,int ei){
        int[] temp= new int[ei-si+1];
        int i=si;// Left part pointer
        int j=mid+1;//Right Part Tracker
        int k=0;//temp Array pointer

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
            temp [k] = arr[i];
            i++;
            } else {
            temp [k] = arr[j];
            j++;
            }
            k++;
    }
        // Reaming leftPart
        while(i<=mid){
            temp[k++]=arr[i++];
           
        }
        //Reaming Right Part
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        // Copy The array in arginal;
        for(k=0,i=si;k<temp.length;i++,k++){
            arr[i]=temp[k];
        }

    }
    public static void main(String[] args) {
        int[]arr={6,3,9,3,5,2,8,-2};
        SortArr(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
