public class Presubfix {
    public static int minimumLength(String s) {
        int n=s.length();
        if(n<2)return n;
        if(s.charAt(0)!=s.charAt(n-1))return n;
        int si=0;
        int ei=n-1;
        
        while (si<=ei && s.charAt(si)==s.charAt(ei)) {
            char prev=s.charAt(si);
           while(si<=ei && s.charAt(si)==prev){
            si++;
           }
           while(si<=ei && s.charAt(ei)==prev){
            ei--;
           }

        }
        
        return ei-si+1;
    }
    public static void main(String[] args) {
        String s="cabbac";
        System.out.println(minimumLength(s));
    }
}
