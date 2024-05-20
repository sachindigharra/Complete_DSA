package sort;

import java.util.Arrays;

public class Quick {
    public static void quick_Sort(int[] arr, int si,int ei) {
		if(si>=ei)return;
		int pidx=parition(arr, si, ei);
		quick_Sort(arr, si, pidx-1);
		quick_Sort(arr, pidx+1, ei);
	}
	public static int parition(int[] arr,int si,int ei) {
		int pivot=arr[ei];
		int i=si-1;
		for(int j=si;j<ei;j++) {
			if(arr[j]<=pivot) {
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
		System.out.print(Arrays.toString(arr));
		return i;
	}
	public static void main(String[] args) {
		int[]nums={5,10,3,6,9,2,11,4};
		quick_Sort(nums, 0, nums.length-1);
	}
}
