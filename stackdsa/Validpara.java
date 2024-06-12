import java.util.*;
public class Validpara {
    public boolean isValid(String Str) {
        Stack<Character>s=new Stack<>();
        for(int i=0;i<Str.length();i++){
          char x=Str.charAt(i);
          if("({[".indexOf(x)>=0){
            s.push(x);
          }
          else if(")}]".indexOf(x)>=0){
            if(s.isEmpty()){
                return false;
            }
              char y=s.pop();
             if((y=='('&&x==')')||(y=='{'&&x=='}')||(y=='['&&x==']')){

                }
                else{
                  return false;
                }
          }
        }
        return s.isEmpty();
    }   
    public static void main(String[] args) {
        String Str="()[]{}";
        System.out.print(isValid(str));
    }
}
