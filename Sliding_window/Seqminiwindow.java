import java.util.*;

public class Seqminiwindow {
    public static String minWindow(String S, String T) {
        int s = S.length();
        int t = T.length();
        int[][] dp = new int[s][t];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < s; i++) {
            if (S.charAt(i) == T.charAt(0)) {
                dp[i][0] = i;
            } else {
                if (i != 0) {
                    dp[i][0] = dp[i-1][0];
                }
            }
        }
        for (int i = 1; i < s; i++) {
            for (int j = 1; j < t; j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int begin = -1, length = Integer.MAX_VALUE;
        for (int i = 0; i < s; i++) {
            int index = dp[i][t-1];
            System.out.print(index+" ");
            if (index != -1) {
                int curLength = i - index + 1;
                System.out.print(" "+length);
                if (curLength < length) {
                    begin = index;
                    length = curLength;
                    
                }
            }
        }
        if (begin == -1)
            return "";
        return S.substring(begin, begin + length);
    }
    // public static String minWindow(String s, String t) {

    //     if(s== null || t == null || s.length()==0 || t.length()==0) return new String();
    //     if(s.equals(t))return s;
    //     if(s.length()<t.length())return "";
    //     // Auxilary Array for tracking freq. of character of target String --> t
    //     int[]map = new int[128];
    //     List<Integer>indx=new ArrayList<>();
    //     for(char ch:t.toCharArray()){
    //         map[ch]++;
    //         if(map[ch]>1)indx.add(ch-'a');
    //     }
    //     int n=s.length();
    //     char[]ch= s.toCharArray();
    //     int r=0;
    //     int l=0;
    //     int count=0;
    //     int si=-1;
    //     int minLen=Integer.MAX_VALUE;
    //     while(r<n){
    //         if(map[ch[r]]>0)count++;
    //         map[ch[r]]--;
    //         while(count==t.length()){
    //             String str=s.substring(l,r+1);
    //             boolean flag=false;
    //             for(int i=0;i<t.length()-1;i++){
                    
    //                 if(indx.indexOf((t.charAt(i)-'a'))>-1 && (str.indexOf(t.charAt(i))>str.indexOf(t.charAt(i+1)) || str.lastIndexOf(t.charAt(i))<str.indexOf(t.charAt(i+1)) )){
    //                     map[ch[l]]++;
    //                         if(map[ch[l]]>0)count--;
    //                         l++;
    //                         flag=true;
    //                         break;
    //                 }
    //                 else if(str.indexOf(t.charAt(i))>str.indexOf(t.charAt(i+1))){
    //                     System.out.println("skip this String");
    //                         map[ch[l]]++;
    //                         if(map[ch[l]]>0)count--;
    //                         l++;
    //                         flag=true;
    //                         break;

    //                 }
    //             }
                
    //             if( !flag&&r-l+1<minLen){
    //                 minLen=r-l+1;
    //                 si=l;
    //             }
    //             map[ch[l]]++;
    //             if(map[ch[l]]>0)count--;
    //             l++;
    //         }
    //         r++;
    //     }
    //     return si==-1?"":s.substring(si,(si+minLen));
        
    // }
    public static void main(String[] args) {
        String s="baasakbcdebbde";
        String t="bde";
        System.out.println(minWindow(s, t));
        
    }
}
