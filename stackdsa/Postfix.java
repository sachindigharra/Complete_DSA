import java.util.Stack;
public class Postfix {
    static String createPostfix(String str){
        Stack<Integer>s=new Stack<>();
        for(Character ch:str.toCharArray()){
            if(Character.isDigit(ch)){
                int x=ch-'0';
                s.push(x);
            }
            else if(ch=='+'){
                int  ch1=s.pop()-'0';
                int  ch2=s.pop()-'0';
                s.push(ch1+ch2);
            }
            else if(ch=='-'){
                int  ch1=s.pop()-'0';
                int  ch2=s.pop()-'0';
                s.push(ch1-ch2);
            }
            else if(ch=='*'){
                int  ch1=s.pop()-'0';
                int  ch2=s.pop()-'0';
                s.push(ch1*ch2);
            }
            else if(ch=='/'){
                int  ch1=s.pop()-'0';
                int  ch2=s.pop()-'0';
                s.push(ch1/ch2);
            }
        }

        return ""+s.pop();
    }
    public static void main(String[] args) {
        String str="23+4-1 "; 
        System.out.println(createPostfix(str));
    }
    
}
