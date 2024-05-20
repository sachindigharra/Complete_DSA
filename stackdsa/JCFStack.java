import java.util.*;;
public class JCFStack {
    static void pushAtbottom(Stack<Integer>s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtbottom(s, data);
        s.push(top);

    }
    static boolean isDuplicatepara(String s){
        Stack<Character>box=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                int count=0;
                while(!box.isEmpty() && box.peek()!='('){
                    box.pop();
                    count++;
                }
                if(count<1) return true;
                else{
                    box.pop();
                }
            }
            else{
                box.push(ch);
            }
        }
        return false;
    }
    static void stackPrint(Stack<Integer>s){
        if(s.isEmpty()){
            return;
        }
        System.out.println(s.pop());
        stackPrint(s);

    }
    static String reverseString(String str){
        if(str=="" ||str.length()<=1){
            return str;
        }
        int i=0;
        Stack<Character>ch=new Stack<>();
        while(i<str.length()){
                ch.push(str.charAt(i));
                i++;
        }
        str="";
        while(!ch.isEmpty()){
            str+=ch.pop();
        }
        return str;
    }
    static void reverseStack(Stack<Integer>s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushAtbottom(s, top);
    }
    public static void main(String[] args) {
        // Stack<Integer>s=new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtbottom(s,4);
        // stackPrint(s);
        // String str="abc";
        // System.out.println(reverseString(str));
        // reverseStack(s);
        // stackPrint(s);
        String s="((a+b)+(c+d))";
        System.out.println(isDuplicatepara(s));
    }
}
