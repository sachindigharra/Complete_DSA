import java.util.*;

public class Minimumkdigitremove {
    public  static String removeKdigits(String num, int k) {
        if(num.length()==k)return "0";
        Stack<Character>seq = new Stack<>();

        for(char digit:num.toCharArray()){
            while(!seq.isEmpty() && k>0 && seq.peek()>digit){
                seq.pop();
                k--;
            }
            seq.push(digit);
        }
        // remove left k digit from stack of sequence of digit 
        // top of seq will be larger 
        // mini value shift left side
        while(k>0 && !seq.isEmpty()){
            seq.pop();
            k--;
        }
        StringBuilder str=new StringBuilder();
        // add char digit in String builder
        while(!seq.isEmpty()){
            str.append(seq.pop());
        }
        // reverse str beacuse we use stack
        str.reverse();
        // trim all leading 0
        while(str.length()>0 && str.charAt(0)==0){
            str.deleteCharAt(0);
        }
        return str.length()>0?str.toString():"0";
    }
    public static void main(String[] args) {
         String num = "1432219"; int k = 3;
         System.out.println(removeKdigits(num, k));
    }
}
