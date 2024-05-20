import java.util.Arrays;
import java.util.Stack;

public class Duplicateletter{
    public static String removeDuplicateLetters(String s) {
        Stack<Character>box=new Stack();
       boolean []track = new boolean[26];
       Arrays.fill(track,false);
        for(int i=0;i<s.length();i++){
           char ch=s.charAt(i);
           if(track[ch-'a'])continue;
           while(!box.isEmpty()&& box.peek()>ch){
               track[box.pop()-'a']=false;
           }
            box.push(ch);
            track[ch-'a']=true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!box.isEmpty())
            sb.append(box.pop());
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String s="cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }
}