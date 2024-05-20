import java.util.HashMap;

public class Longestsubchar {
    public static int longestSubstring(String s, int k) {
        int  n=s.length();
        int left=0;
        int right=0;
        int len=Integer.MIN_VALUE;
        HashMap<Character,Integer>map=new HashMap<>();

        while(right<n){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            while(left<=right && map.get(ch)>k){
                char c=s.charAt(left);
                map.put(c,map.get(c)-1);
                left++;
            }
            len=Math.max(len, (right-left)+1);
            right++;
        } 
        return len;
    }
    public static void main(String[] args) {
         String s = "ababbc";
         int k=2;
         System.out.println(longestSubstring(s, k));
    }
}
