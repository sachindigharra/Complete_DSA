import java.util.*;
public class Validpara {
    public static void main(String[] args) {
        String Str="()[]{}";
        Stack<Character>s=new Stack<>();
        for(int i=0;i<Str.length();i++){
            char x=Str.charAt(i);
            if("({[".indexOf(x)>=0){
              s.push(x);
            }
            else if(")}]".indexOf(x)>=0){
                //char y=s.pop();
   
            }
          }
      
      System.out.println(s.isEmpty());
    }
}
