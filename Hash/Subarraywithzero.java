import java.util.*;
public class Subarraywithzero {
    public static int subArrayWithsumZero(int[]nums){
        int sum=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        int maxlen=0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
           if(map.containsKey(sum)){
               maxlen=Math.max(maxlen,j-map.get(sum));
               System.out.println(maxlen);
           }
           else{
               map.put(sum,j);
           }
          
        }
        return maxlen;
    }

    public static int subArrayequaltok(int k,int[]nums){
        int count=0;
        int sum=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int i:nums){
            sum+=i;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
       int[]x={1,0,-1,0};
       int len=subArrayWithsumZero(x);
    }
}
