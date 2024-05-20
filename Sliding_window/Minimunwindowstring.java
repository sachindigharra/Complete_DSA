import java.util.HashMap;

public class Minimunwindowstring {
    public static String minWindow(String s, String t) {
        // corner case
        if(s.equals(t))return s;
        if(s.length()<t.length())return "";
        
        int m=t.length();
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i =0;i<m;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i), 0)+1);
            
        }
        int r=0;
        int l=0;
        int count=0;
        int minLen=Integer.MAX_VALUE;
        int si=-1;
        while(r<n){
            char ch=s.charAt(r);
           
            if(map.containsKey(ch) ){
                if(map.get(ch)>0){
                    count++;
                }
                map.put(ch,map.get(ch)-1);
                
            }
            while (count==m ){

                
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    si=l;
                }
                
                map.put(s.charAt(l),map.get(s.charAt(l))+1);
                if(map.get(s.charAt(l))>0)count--;
                l++;
            }
            if(!map.containsKey(ch)){
                map.put(ch,-1);
            } 
            r++;
        }
        int ei=si+minLen;
        return si==-1?"":s.substring(si,ei );
    }
    public static void main(String[] args) {
        String s = "AB", t = "A";
        System.out.println(minWindow(s, t));
    }
}
