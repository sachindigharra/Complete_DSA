import java.util.*;
public class Reverseword {
    public static String reverseWords(String s) {
        if(s.length()==1)return s;
        Stack<String>box=new Stack<>();
        String str="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                char c=s.charAt(i);
                str+=c;
                }
            else{
                    if(!str.equals("")){
                        System.out.println(str);
                        box.push(str);
                        str="";
                }
            }
            
        }
        while(!box.isEmpty()){
            System.out.println(box.peek());
            box.pop();
        }

        return "";

    }
    public static void main(String[] args) {
        String s="Sky is Blue";
        System.out.println(reverseWords(s));
    }
}
