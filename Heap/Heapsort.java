public class Heapsort {
    public static void heapify(int[] arr,int i,int n){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;
        // check weather left is maxmum then root
        if(left<n &&arr[left]>arr[maxIdx]){
            maxIdx=left;
        }
        // check weather right is minimum then root
        if(right<n &&arr[right]>arr[maxIdx]){
            maxIdx=right;
        }
        //root node satify the min heap condition or not
        if(maxIdx!=i){
            int temp=arr[i];
            arr[i]=arr[maxIdx];
           arr[maxIdx]=temp;
            // check for next child is valid for min Heap
            heapify(arr,maxIdx,n);
        }
        
    }
    public static void sort(int[]x){
        //bulid Max heap
        int n=x.length;
        for(int i=n/2;i>=0;i--){
            heapify(x,i,n);
        }
        //swap largerst first with last element
        for(int i=n-1;i>=0;i--){
            int temp=x[i];
            x[i]=x[0];
            x[0]=temp;
            heapify(x,0,i);
        }

    }
    public static void main(String[] args) {
        int[] x={1,5,4,3,2};
        sort(x);
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
    }
}
