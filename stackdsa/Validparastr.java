public class Validparastr {
    // leet 678
    public static boolean checkValidString(String s) {
        int open=0;
        int smy=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(')open++;
            else if(ch=='*')smy++;
            else{
                if(open>0)open--;
                else if(smy>0)smy--;
                else{
                    return false;
                }
            }
            
        }
        System.out.println(open);
        System.out.println(smy);
        if(open!=0 && open>smy)return false;
       return true; 
    }
    public static void main(String[] args) {
        String s="(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        System.out.println(checkValidString(s));
    }
}
