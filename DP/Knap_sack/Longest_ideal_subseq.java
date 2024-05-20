import java.util.*;
public class Longest_ideal_subseq {
    public static int lengthOfIdealSub(int i,int k, String s){
        Stack<Character>box=new Stack<>();
        box.push(s.charAt(i));
        int l=i-1;
        int r=i+1;
        int subLen=0;
        while(l>=0){
            char ch=s.charAt(l);
            if(!box.isEmpty() &&Math.abs(box.peek()-ch)<=k){
                box.push(ch);
            }
            l--;
        }
        subLen+=box.size();
        subLen--;
        
        box.clear();
        box.push(s.charAt(i));
        while(r<s.length()){
            char ch=s.charAt(r);
            if(!box.isEmpty() &&Math.abs(box.peek()-ch)<=k){
                box.push(ch);
            }
            r++;
        }
        
       subLen+=box.size();
       subLen--;

       //we sub sublen by 2 beacuse we inlude 
        return subLen<=0?1:subLen+1;
    }
    public static int longestIdealString(String s, int k) {
        int res=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
           res=Math.max(res,lengthOfIdealSub(i, k, s));
           //System.out.println(res);
        }
        return res;
    }
    public static void main(String[] args) {
        String s ="acfgbd";
        int k=2;
        System.out.println(longestIdealString(s, k));
        //System.out.println('c'-'j');
    }
    
}
