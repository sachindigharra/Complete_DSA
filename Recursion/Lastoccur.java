public class Lastoccur {
    static int isLastoccur(int[]arr,int key,int i){
        if(i==arr.length)return -1;
        int found = isLastoccur(arr, key, i+1);
        if(found==-1 && arr[i]==key)return i;
        return found;
    }
    public static void main(String[] args) {
        int[] n = {1,2,23,4,5,6,7,8,9,1,1};
        System.out.println(isLastoccur(n, 1, 0));
    }
}
