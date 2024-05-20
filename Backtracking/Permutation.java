import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list,new ArrayList<>(),nums);
        return list;

    }
    public static void backTrack( List<List<Integer>> list,List<Integer> tempList,int[]nums){
        if(nums.length==tempList.size())list.add(new ArrayList<>(tempList));
        for(int i=0;i<nums.length;i++){
        if(tempList.contains(nums[i])) continue; // element already exists, skip
         tempList.add(nums[i]);
         backTrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[]nums={1,2,3}; 
        List<Integer>ls=new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.remove(0);
        System.out.println(ls);
        //System.out.println(permute(nums));
    }
}
