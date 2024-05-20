import java.util.*;

public class Advancepremute {
    static class Pair {
        int idx;
        int val;
        public Pair(int _idx,int _val){
            idx=_idx;
            val=_val;
        }
    }
    private static void backTrack(List<List<Integer>> list,List<Integer> tempList,int[]nums,boolean[]used){
        if(nums.length==tempList.size()){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
        if(used[i]) continue; // element already exists, skip
        if(i>0&& nums[i]==nums[i-1] && !used[i-1])continue; // previous value same but not used
         tempList.add(nums[i]);
         used[i]=true;
         backTrack(list, tempList, nums,used);
         used[i]=false;
         tempList.remove(tempList.size() - 1);
        }
    }
    public   static List<List<Integer>> uniquepermutation(int[]nums){
        List<List<Integer>>list=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        backTrack(list,new ArrayList<>(),nums,used);
        return list;
    }
    public static void main(String[] args) {
        int[] x={1,1,2};
        List<List<Integer>>ls=uniquepermutation(x);
        for(List<Integer> l:ls){
            System.out.println(l);
        }
    }
}
