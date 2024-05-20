import java.util.*;
public class Infixtoprefix {
    public static String topostFix(String str){
        Stack<Character>S=new Stack<>();
        char symbol;  
        String postfix = "";  
        for(int i=0;i<str.length();++i){  
                symbol = str.charAt(i);    
                if (Character.isLetter(symbol))  
                postfix = postfix + symbol;  
                else if (symbol=='('){  
                    S.push(symbol);  
                }  
                else if (symbol==')'){  
                    while (S.peek() != '('){  
                        postfix = postfix + S.pop();  
                    }  
                    S.pop();       
                }  
                else{  
                while (!S.isEmpty() && !(S.peek()=='(') && prec(symbol) <= prec(S.peek()))  
                postfix = postfix + S.pop();  
                S.push(symbol);  
                }  
        }  
        while (!S.isEmpty())  
        postfix = postfix + S.pop();  
        return postfix;  
        }  
        static int prec(char x)  {  
            if (x == '+' || x == '-')  
            return 1;  
            if (x == '*' || x == '/' || x == '%')  
            return 2;  
            return 0;  
        }  
    public static void main(String[] args) {
        String str="k+l-m*n+(o^p)*w/u/v*t+q";
        System.out.println(topostFix(str));
        
    }
}
