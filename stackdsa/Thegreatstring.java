import java.util.Stack;

public class Thegreatstring {
    public static String makeGood(String s) {
        if(s.length()<2)return s;
        Stack<Character>box = new Stack<>();
        box.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(!box.isEmpty()){
                char c1=(char) (ch+32);
                char c2=(char)(ch-32);
                if(box.peek()==c1 || box.peek()==c2)box.pop();
                else box.push(ch);
            }
            else{
                box.push(ch);
            }

        }
        if(box.isEmpty())return "";
        StringBuilder str=new StringBuilder();
        while(!box.isEmpty()){
            str.append(box.peek());
            box.pop();
        }
        str.reverse();

        return str.toString();
    }
    public static void main(String[] args) {
        String s="Pp";
        System.out.println(makeGood(s));
    }
}
