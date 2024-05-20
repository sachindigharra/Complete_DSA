import java.util.HashMap;

public class Fruitbasket {
    public static int maxFruitinBasket(int[]nums,int k){
        if(nums.length==k)return k;
        int n=nums.length;
        int l=0;
        int r=0;
        int count=0;
        int max=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        while(r<n){

            while(map.size()==k && !map.containsKey(nums[r])){
                map.put(nums[l],map.get(nums[l])-1);
                count--;
                if(map.get(nums[l])==0)map.remove(nums[l]);

                l++;
            }
            map.put(nums[r],map.getOrDefault(nums[r], 0)+1);
            count++;
            max=Math.max(count, max);
            r++;
        }
        return max;

    }
    public static void main(String[] args) {
        int[]nums={1,2,3,4};
        int k=2;
        System.out.println(maxFruitinBasket(nums, k));
    }
}
