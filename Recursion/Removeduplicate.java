import java.util.*;
public class Removeduplicate {
    public static String Removeduplicatestr(String s){
       
        boolean []track = new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            track[ch-'a']=true;
        }
        String str="";
        for(int i=0;i<track.length;i++ ){
            if(track[i]){
                char ch=(char)('a'+i);
                str+=ch;
            }
        }
        return str;
    }
    public static void main(String[] args) {
        System.out.println(Removeduplicatestr("abcdbhbdbk"));
    }
}
