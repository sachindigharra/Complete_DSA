import java.util.Stack;

public class Makevalidpara {
    static class Pair{
        char c;
        int idx;
        public Pair(char _c,int _idx){
            c=_c;
            idx = _idx;
        }
    }
    public static  String minRemoveToMakeValid(String s) {
        Stack<Pair>box=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if("()".indexOf(ch)>-1){
                if(!box.isEmpty()){
                    if(ch==')' && box.peek().c=='('){
                        box.pop();
                    }
                    else{
                        box.push(new Pair(ch, i));
                    }
                }
                else{
                    box.push(new Pair(ch, i));
                }
            }
        }
        if(box.isEmpty())return s;
        StringBuilder str = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            if(!box.isEmpty() && box.peek().idx==i){
                box.pop();
                continue;
            }
            str.append(s.charAt(i));
        }
        str.reverse();
        return str.toString();
        
    }
    public static void main(String[] args) {
        String s="lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }
}
