import java.util.HashSet;

public class Longestsubstring {
    public static int longSubStringnonrepeat(String s){
        int n=s.length();
        int r=0;
        int l=0;
        int len=Integer.MIN_VALUE;
        HashSet<Character>set=new HashSet<>();
        while(r<n){
            while(l<=r && set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            len=Math.max(len,(r-l)+1);
           set.add(s.charAt(r));
            
            r++;
        }
        return len;
    }
    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(longSubStringnonrepeat(s));
    }
}
